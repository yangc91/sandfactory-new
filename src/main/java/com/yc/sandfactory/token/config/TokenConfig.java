package com.yc.sandfactory.token.config;


import com.yc.sandfactory.token.key.DefaultTokenKeyGenerator;
import com.yc.sandfactory.token.key.TokenKeyGenerator;

public class TokenConfig {

	/**
	 * @Fields keyGenerator: Key生成器
	 */
	private TokenKeyGenerator keyGenerator = new DefaultTokenKeyGenerator();
	/**
	 * @Fields expiredTimeInMinutes: 过期时间，单位为分钟
	 */
	private long expiredTimeInMinutes = 30;

	/**
	 * @Fields autoDelay: 是否自动延期，当获取Token或Token被更新时，自动延期。
	 */
	private boolean autoDelay = true;

	public TokenKeyGenerator getKeyGenerator() {
		return keyGenerator;
	}

	public void setKeyGenerator(TokenKeyGenerator keyGenerator) {
		this.keyGenerator = keyGenerator;
	}

	public long getExpiredTimeInMinutes() {
		return expiredTimeInMinutes;
	}

	public void setExpiredTimeInMinutes(long expiredTimeInMinutes) {
		this.expiredTimeInMinutes = expiredTimeInMinutes;
	}

	public boolean isAutoDelay() {
		return autoDelay;
	}

	public void setAutoDelay(boolean autoDelay) {
		this.autoDelay = autoDelay;
	}

}
