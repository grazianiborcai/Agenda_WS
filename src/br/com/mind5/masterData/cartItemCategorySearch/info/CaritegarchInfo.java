package br.com.mind5.masterData.cartItemCategorySearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CaritegarchInfo extends InfoRecord implements Cloneable {
	public char codItemCateg;
	public String txtItemCateg;
	
	
	public CaritegarchInfo() {
		super();
		
		codItemCateg = DefaultValue.character();
	}
	
	
	
	public static CaritegarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CaritegarchInfo.class);
	}
	
	
	
	public static List<CaritegarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CaritegarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		result = result * 31 + (int) codItemCateg;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CaritegarchInfo))
			return false;
		
		
		CaritegarchInfo obj = (CaritegarchInfo) o;		
		return codItemCateg == obj.codItemCateg;
	}
}
