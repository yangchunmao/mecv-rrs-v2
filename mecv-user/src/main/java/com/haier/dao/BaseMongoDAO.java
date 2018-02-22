package com.haier.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface BaseMongoDAO {
	/** 
     * 通过条件查询实体(集合) 
     *  
     * @param query 
     */  
    public List<?> find(Query query) ;
  
    /** 
     * 通过一定的条件查询一个实体 
     *  
     * @param query 
     * @return 
     */  
    public Object findOne(Query query) ;
  
    /** 
     * 通过条件查询更新数据 
     *  
     * @param query 
     * @param update 
     * @return 
     */  
    public void update(Query query, Update update) ;
  
    /** 
     * 保存一个对象到mongodb 
     *  
     * @param entity 
     * @return 
     */  
    public Object save(Object entity) ;
    
    public Object saveForBaseData(Object entity, String baseName);
  
    /** 
     * 通过ID获取记录 
     *  
     * @param id 
     * @return 
     */  
    public Object findById(String id) ;
  
    /** 
     * 通过ID获取记录,并且指定了集合名(表的意思) 
     *  
     * @param id 
     * @param collectionName 
     *            集合名 
     * @return 
     */  
    public Object findById(String id, String collectionName) ;
      
    /** 
     * 分页查询 
     * @param page 
     * @param query 
     * @return 
     */  
    //public Page<?> findPage(Page<?> page,Query query);  
      
    /** 
     * 求数据总和 
     * @param query 
     * @return 
     */  
    public long count(Query query);

}
