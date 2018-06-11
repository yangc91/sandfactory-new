package com.yc.sandfactory.token.operator;

import com.yc.sandfactory.token.config.TokenConfig;

import java.util.List;
import java.util.Map;

/**
 * Description : Redis会话操作
 * @author : lvhao
 * @date : 2018年4月4日 上午11:33:02
 */
public class RedisTokenOperator extends AbstractTokenOperator {

	public RedisTokenOperator(TokenConfig config) {
		super(config);
	}

	@Override
	public String add(Object value) {
		return null;
	}

	@Override
	public Object get(String token) {
		return null;
	}

	@Override
	public List<Object> values() {
		return null;
	}

	@Override
	public Map<String, Object> all() {
		return null;
	}

	@Override
	public boolean delay(String token) {
		return false;
	}

	@Override
	public boolean invalidate(String token) {
		return false;
	}
}
