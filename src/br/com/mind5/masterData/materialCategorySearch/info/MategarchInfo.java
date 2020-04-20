package br.com.mind5.masterData.materialCategorySearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MategarchInfo extends InfoRecord implements Cloneable {
	public int codMatCateg;
	public String txtMatCateg;
	
	
	public MategarchInfo() {
		super();
		
		codMatCateg = DefaultValue.number();
	}
	
	
	
	public static MategarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MategarchInfo.class);
	}
	
	
	
	public static List<MategarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MategarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codMatCateg;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MategarchInfo))
			return false;
		
		
		MategarchInfo obj = (MategarchInfo) o;		
		return (codMatCateg == obj.codMatCateg);
	}
}
