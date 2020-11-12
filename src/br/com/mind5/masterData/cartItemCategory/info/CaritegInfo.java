package br.com.mind5.masterData.cartItemCategory.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CaritegInfo extends InfoRecord implements Cloneable {
	public char codItemCateg;
	public String txtItemCateg;
	
	
	public CaritegInfo() {
		super();
		
		codItemCateg = DefaultValue.character();
	}
	
	
	
	public static CaritegInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CaritegInfo.class);
	}
	
	
	
	public static List<CaritegInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CaritegInfo.class);
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
		
		
		if (!(o instanceof CaritegInfo))
			return false;
		
		
		CaritegInfo obj = (CaritegInfo) o;		
		return codItemCateg == obj.codItemCateg;
	}
}
