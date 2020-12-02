package br.com.mind5.masterData.discountStrategy.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class DisegyInfo extends InfoRecord implements Cloneable {
	public int codDiscountStrategy;
	public String txtDiscountStrategy; 
	public String descriptionDiscountStrategy;
	
	
	public DisegyInfo() {
		super();
		
		codDiscountStrategy = DefaultValue.number();
	}
	
	
	
	public static DisegyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DisegyInfo.class);
	}
	
	
	
	public static List<DisegyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DisegyInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codDiscountStrategy    ^ (codDiscountStrategy    >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DisegyInfo))
			return false;
		
		
		DisegyInfo obj = (DisegyInfo) o;		
		return (codDiscountStrategy == obj.codDiscountStrategy);
	}
}
