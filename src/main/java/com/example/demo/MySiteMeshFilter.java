package com.example.demo;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class MySiteMeshFilter extends ConfigurableSiteMeshFilter{
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/jsp/decoration.jsp")
		//满足该匹配路径将不被装饰
		.addExcludedPath("/admin/*")
		.addExcludedPath("/static/*")
		.addExcludedPath("/jsp/upload/*")
		.addExcludedPath("/jsp/admin/ueditor/*");

	}
}
