package br.com.mind5.masterData.userCategory.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UseregInfo extends InfoRecord implements Cloneable {
	public char codUserCategory;
	public String txtUserCategory;
	
	
	public UseregInfo() {
		super();
		
		codUserCategory = DefaultValue.character();
	}
	
	
	
	public static UseregInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UseregInfo.class);
	}
	
	
	
	public static List<UseregInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UseregInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) codUserCategory;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UseregInfo))
			return false;
		
		
		UseregInfo obj = (UseregInfo) o;		
		return (codUserCategory == obj.codUserCategory);
	}
}
