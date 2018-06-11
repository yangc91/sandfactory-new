package com.yc.sandfactory.token.operator;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.yc.sandfactory.token.config.TokenConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MemoryTokenOperator extends AbstractTokenOperator{

	private static LoadingCache<String, Object> CONTAINER;
	
	public MemoryTokenOperator(final TokenConfig config) {
		super(config);

		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();
		builder.expireAfterWrite(config.getExpiredTimeInMinutes(), TimeUnit.MINUTES);
		if(config.isAutoDelay()){
			builder.expireAfterAccess(config.getExpiredTimeInMinutes(), TimeUnit.MINUTES);
		}
		CONTAINER = builder.build(new CacheLoader<String, Object>(){

			@Override
			public Object load(String key) throws Exception {
				return null;
			}});
	
	}
	
	@Override
	public String add(Object value) {
		String key = super.config.getKeyGenerator().key();
		CONTAINER.put(key, value);
		return key;
	}

	@Override
	public Object get(String token) {
		return CONTAINER.getIfPresent(token);
	}
	
	@Override
	public List<Object> values() {
		return new ArrayList<Object>(CONTAINER.asMap().values());
	}
	
	@Override
	public Map<String, Object> all() {
		return CONTAINER.asMap();
	}

	@Override
	public boolean delay(String token) {
		try {
			CONTAINER.get(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean invalidate(String token) {
		CONTAINER.invalidate(token);
		return true;
	}

}
