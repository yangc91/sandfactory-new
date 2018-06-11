package com.yc.sandfactory.token;


import com.yc.sandfactory.token.operator.TokenOperator;

public class TokenFactory {

	private TokenOperator operator;
	
	public TokenOperator getOperator() {
		return operator;
	}

	public void setOperator(TokenOperator operator) {
		this.operator = operator;
	}
}
