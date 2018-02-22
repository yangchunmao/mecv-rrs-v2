package com.haier.dao.impl;

import com.haier.dao.BaseMongoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class BaseMongoDAOImpl<T> implements BaseMongoDAO {
	private static final int DEFAULT_SKIP = 0;  
    private static final int DEFAULT_LIMIT = 200; 
    
    /** 
     * spring mongodb　集成操作类　 
     */  
    @Autowired
    protected MongoTemplate mongoTemplate;

	@Override
	public List<T> find(Query query) {
		return (List<T>) mongoTemplate.find(query, getGenericClass(this.getClass()));
	}

	@Override
	public T findOne(Query query) {
		return (T)mongoTemplate.findOne(query, getGenericClass(this.getClass()));  
	}

	@Override
	public void update(Query query, Update update) {
		mongoTemplate.findAndModify(query, update, getGenericClass(this.getClass())); 
		
	}
	@Override
	public Object save(Object entity) {
		mongoTemplate.insert(entity);
		//mongoTemplate.insert
        return entity;  
	}
	@Override
	public Object saveForBaseData(Object entity, String baseName) {
		mongoTemplate.save(entity,baseName);
		//mongoTemplate.insert
        return entity;  
	}
	@Override
	public T findById(String id) {
		return (T)mongoTemplate.findById(id, getGenericClass(this.getClass()));  
	}

	@Override
	public T findById(String id, String collectionName) {
		return (T)mongoTemplate.findById(id, getGenericClass(this.getClass()), collectionName);  
	}
	public Page<Object> findPage(Page<Object> page, Query query) {
		long count = this.count(query);  
        return page;  
	}
	@Override
	public long count(Query query) {
		 return mongoTemplate.count(query, getGenericClass(this.getClass()));  
	}
  
	/**
     * 获取接口的泛型类型，如果不存在则返回null
     * @param clazz
     * @return
     */
    private Class<?> getGenericClass(Class<?> clazz) {
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            return ((Class<?>) p[0]);
        }
        return null;
    }

}
