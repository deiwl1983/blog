package com.example.demo.daoimpl;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaQuery;

import com.example.demo.command.AddArticleCommand;
import com.example.demo.command.BaseCommand;
import com.example.demo.command.ListArticleCommand;
import com.example.demo.command.ListHomeArticleCommand;
import com.example.demo.model.ArticleTagRelative;
import com.example.demo.model.Tag;
import com.example.demo.model.UserInfo;
import com.example.demo.util.CriteriaMerger;
import com.example.demo.util.CriteriaUtils;
import com.example.demo.vo.PageBean;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ArticleDao;
import com.example.demo.model.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Article> queryArticle(Integer userId) {
		
		String hql = "from Article  where userId = " +userId;
		
		Query query = entityManager.createQuery(hql);
		
		List<Article> articleList = query.getResultList();
		
		return articleList;
	}

	@Override
	public Article add(AddArticleCommand cmd) {
		Article article = new Article();
		article.setTitle(cmd.getTitle());
		article.setSummary(cmd.getSummary());
		//article.setAuthor(cmd.g);
		article.setContent(cmd.getContent());
		article.setCreatedDate(cmd.getCreatedDate());
		UserInfo user  = entityManager.find(UserInfo.class,cmd.getUserId());
		article.setAuthor(user.getNickname());
		article.setUserId(user.getId());
		entityManager.persist(article);

		if(cmd.getTags() != null){
			for(Long tagId :cmd.getTags()){
				Tag tag = entityManager.find(Tag.class,tagId);
				ArticleTagRelative relative = new ArticleTagRelative();
				relative.setArticle(article);
				relative.setTag(tag);
				entityManager.persist(relative);
			}
		}


		return article;
	}

	public PageBean list2(ListArticleCommand cmd) {
		List<Object> params = new ArrayList<>();
		StringBuffer queryBuf = new StringBuffer("from Article a where 1=1 ");
		StringBuffer countQueryBuf = new StringBuffer("select count(a.id) from Article a where 1=1 ");
		StringBuffer where=new StringBuffer();
		if (cmd.getTitle() != null) {
			where.append(" and a.title like ? ");
			params.add("%"+cmd.getTitle()+"%");
		}
		if(cmd.getStartDate()!=null){
			where.append(" and a.createdDate >= ? ");
			params.add(cmd.getStartDate());
		}
		if(cmd.getEndDate()!=null){
			where.append(" and a.createdDate <= ? ");
			params.add(cmd.getEndDate());
		}
		Query countQuery = entityManager.createQuery( countQueryBuf.append(where).toString());
		Query query = entityManager.createQuery( queryBuf.append(where).toString());
		Stream.of(countQuery,query).forEach((Query q)->{
			int i=0;
			for(Object param:params){
				q.setParameter(i,param);
				i++;
			}
		});

		Long count=(Long)countQuery.getSingleResult();
		List<Article> ret=query.setFirstResult(cmd.getStart()).setMaxResults(cmd.getLength()).getResultList();
		PageBean<Article>  page=new PageBean<>(ret,count);
		return  page;
	}

	/**
	 * Spring JPA使用CriteriaBuilder动态构造查询
	 * 在使用Spring JPA提供的方法只能进行简单的CRUD，如果遇到复杂的情况就需要我们动态来构建查询条件了。这里我们来看使用CriteriaBuilder如何来构造查询。
	 * 核心代码：
	 *  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	 *  CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
	 *  Root<Order> root = query.from(Order.class);
	 *  query.select(criteriaBuilder.count(root.get("id")));
	 *  Predicate predicate = criteriaBuilder.equal(root.get("id"), 1);
	 *  query.where(predicate);
	 *  Long singleResult = entityManager.createQuery(query).getSingleResult();
	 * 调用entityManager.getCriteriaBuilder()来获取CriteriaBuilder。CriteriaBuilder可以用于创建CriteriaQuery、CriteriaUpdate和CriteriaDelete。除此之外类似count、max等函数也是由CriteriaBuilder来创建的。其中Entitymanager可以使用@PersistenceContext注解来进行注入。
	 * 调用criteriaBuilder.createQuery来创建CriteriaQuery。其中createQuery的参数是Query返回值类型。
	 * 调用query.from(Order.class)。参数是对应于order表的实体类，query.from类似于sql中的from语句，该方法的执行等价于sql中的from order。
	 * 调用 query.select创建映射。 query.select(criteriaBuilder.count(root.get(“id”)))等价于select count(id)。如果执行query.select(root)则等价于select *。
	 * 使用CriteriaBuilder构造查询条件Predicate，该predicate也就是在where后面的条件子句。
	 * 将Predicate放在 query.where中。
	 * 最后执行查询获取数据。
	 * @param cmd
	 * @return
	 */
	@Override
	public PageBean list(ListArticleCommand cmd) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		PageBean page= createBaseQuery((CriteriaMerger t)->{
			List<Predicate> list=new ArrayList<>();
			if(cmd.getTitle()!=null){
				list.add(cb.like(t.getPath().get("title"),"%"+cmd.getTitle()+"%"));
			}
			if(cmd.getStartDate()!=null){
				list.add(cb.greaterThanOrEqualTo(t.getPath().get("createdDate"),cmd.getStartDate()));
			}
			if(cmd.getEndDate()!=null){
				list.add(cb.lessThanOrEqualTo(t.getPath().get("createdDate"),cmd.getEndDate()));
			}
			if(!list.isEmpty()){
				t.getQuery().where(list.toArray(new Predicate[list.size()]));
			}
		},cb,Article.class,cmd);

		return page;
	}

	@Override
	public Article findById(Long id) {
		Article article = entityManager.find(Article.class,id);
		return article;
	}

	@Override
	public Article updateArticle(Article article) {
		//Article article1 = entityManager.find(Article.class,article.getId());
		//article1.setTitle(article.getTitle());
		//article1.setContent(article.getContent());
		Article article1 =entityManager.merge(article);
		return article1;
	}

	@Override
	public void deleteArticle(Article article) {
		entityManager.remove(article);
	}

	@Override
	public PageBean queryArticleList(ListHomeArticleCommand cmd) {
		List<Object> params = new ArrayList<>();
		StringBuffer queryBuf = new StringBuffer("select distinct a from Article a left join ArticleTagRelative b  on a=b.article where 1=1 ");
		StringBuffer countBuf = new StringBuffer("select count(distinct a.id) from Article a left join ArticleTagRelative b on a=b.article where 1=1 ");
		StringBuffer where = new StringBuffer();

		if(cmd.getTagId() != null){
			where .append(" and b.tag.id = ? ");
			params.add(cmd.getTagId());
		}

		Query countQuery  = entityManager.createQuery(countBuf.append(where).toString());
		Query query  = entityManager.createQuery(queryBuf.append(where).append(" order by a.createdDate desc ").toString());


		Stream.of(countQuery,query).forEach((Query q)->{
			int i = 0;
			for (Object param:params) {
				q.setParameter(i,param);
				i++;
			}
		});

		Long count = (Long)countQuery.getSingleResult();

		List<Article> ret = query.setFirstResult(cmd.getStart()).setMaxResults(cmd.getLength()).getResultList();
		PageBean<Article> page = new PageBean<>(ret,count);
		return page;
	}

	//流式API和lambda表达式
	//JPA Criteria 查询
	//HQL
	private <T> PageBean  createBaseQuery(Consumer<? super CriteriaMerger> criteriaActoin, CriteriaBuilder cb, Class<T> entityClass, BaseCommand cmd) {
		CriteriaMerger<T,Long> countMerger=CriteriaUtils.createCount(cb,entityClass);
		CriteriaMerger<T,T> merger=CriteriaUtils.create(cb,entityClass);
		Stream.of(countMerger,merger).forEach(criteriaActoin);
		Long count=entityManager.createQuery(countMerger.getQuery()).getSingleResult();
		Query query=entityManager.createQuery(merger.getQuery());
		query.setFirstResult(cmd.getStart()).setMaxResults(cmd.getLength());
		List<T> ret=query.getResultList();
		PageBean<T>  page=new PageBean<>(ret,count);
		page.setDraw(cmd.getDraw());
		page.setRecordsFiltered(count);
		return page;
	}

//	public PageBean list3(ListArticleCommand cmd) {
//
//		CriteriaMerger<Article,Long> countMerger=CriteriaUtils.createCount(cb,Article.class);
//		CriteriaMerger<Article,Article> merger=CriteriaUtils.create(cb,Article.class);
//		Stream.of(countMerger,merger).forEach((CriteriaMerger t)->{
//			List<Predicate> list=new ArrayList<>();
//			if(cmd.getTitle()!=null){
//				list.add(cb.like(t.getPath().get("title"),"%"+cmd.getTitle()+"%"));
//			}
//			if(cmd.getStartDate()!=null){
//				list.add(cb.greaterThanOrEqualTo(t.getPath().get("createdDate"),cmd.getStartDate()));
//			}
//			if(cmd.getEndDate()!=null){
//				list.add(cb.lessThanOrEqualTo(t.getPath().get("createdDate"),cmd.getEndDate()));
//			}
//			if(!list.isEmpty()){
//				t.getQuery().where(list.toArray(new Predicate[list.size()]));
//			}
//		});
//		Long count=entityManager.createQuery(countMerger.getQuery()).getSingleResult();
//		Query query=entityManager.createQuery(merger.getQuery());
//		query.setFirstResult(cmd.getStart()).setMaxResults(cmd.getLength());
//		List<Article> ret=query.getResultList();
//		PageBean<Article>  page=new PageBean<>(ret,count);
//		return page;
//	}
}
