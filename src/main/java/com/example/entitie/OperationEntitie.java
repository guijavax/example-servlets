package com.example.entitie;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OperationEntitie {
	
	public OperationEntitie(double value1, double value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	private double value1;
	private double value2;
	
	public double getValue1() {
		return value1;
	}

	public double getValue2() {
		return value2;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
