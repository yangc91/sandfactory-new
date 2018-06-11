package com.yc.sandfactory.token.key;


import com.yc.sandfactory.util.UUIDUtil;

public class DefaultTokenKeyGenerator implements TokenKeyGenerator{

	@Override
	public String key() {
		return UUIDUtil.random();
	}

}
