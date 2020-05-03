package br.com.mind5.masterData.feeCategorySearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FeecatarchInfo extends InfoRecord implements Cloneable {
	public char codFeeCateg;
	public String txtFeeCateg;
	
	
	public FeecatarchInfo() {
		super();
		
		codFeeCateg = DefaultValue.character();
	}
	
	
	
	public static FeecatarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeecatarchInfo.class);
	}
	
	
	
	public static List<FeecatarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeecatarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		result = result * 31 + (int) codFeeCateg;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FeecatarchInfo))
			return false;
		
		
		FeecatarchInfo obj = (FeecatarchInfo) o;		
		return codFeeCateg == obj.codFeeCateg;
	}
}
