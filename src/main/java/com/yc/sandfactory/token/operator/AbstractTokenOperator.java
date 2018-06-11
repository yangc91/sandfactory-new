package com.yc.sandfactory.token.operator;


import com.yc.sandfactory.token.config.TokenConfig;

/**
 * Description : 会话操作抽象类
 * @author : lvhao
 * @date : 2018年4月3日 下午3:37:53
 */
public abstract class AbstractTokenOperator implements TokenOperator{

	/** 
	* @Fields config: Token配置设置
	*/
	protected TokenConfig config;

	public AbstractTokenOperator(TokenConfig config) {
		this.config = config;
	}
	
}
