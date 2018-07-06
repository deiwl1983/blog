package com.example.demo.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 切换标题 ：日记，欣赏，程序人生，经典语录
 */
public enum LiteratureEnum {

    DIARY("日记",1),
    APPRECIATE("欣赏",2),
    JOACHERN("程序人生",3),
    FCMGFCIQUS("经典语录",4);

    private  String desc;
    private Integer value;

    LiteratureEnum(String desc, Integer value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static LiteratureEnum getEnum(Integer value){
        if(value ==null){
            return  null;
        }
        LiteratureEnum resultEnum = null;
        LiteratureEnum[] enumAry = LiteratureEnum.values();
        for(int i=0; i<enumAry.length;i++){
          if (enumAry[i].getValue()==value){
              resultEnum = enumAry[i];
              break;
          }
        }
        return resultEnum;
    }

    public  static  Map<String,Map<String,Object>> toMap(){
        LiteratureEnum[] ary = LiteratureEnum.values();
        Map<String,Map<String,Object>> enumMap = new HashMap<String,Map<String,Object>>();
        for (int num =0; num<ary.length; num++){
            Map<String,Object> map = new HashMap<String,Object>();
            String key = String.valueOf(ary[num].getValue());
            map.put("value",ary[num].getValue());
            map.put("desc",ary[num].getDesc());
            enumMap.put(key,map);
        }
        return enumMap;
    }

    public static  List toList(){
        LiteratureEnum[] ary = LiteratureEnum.values();
        List list= new ArrayList();
        for (int i =0;i<ary.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("desc",ary[i].getDesc());
            map.put("value",ary[i].getValue());
            list.add(map);
        }
        return list;
    }
}
