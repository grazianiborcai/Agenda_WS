package br.com.mind5.masterData.entityCategory.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class EntitegInfo extends InfoRecord implements Cloneable {
	public String codEntityCateg;
	public String txtEntityCateg;
	
	
	public EntitegInfo() {
		super();
	}
	
	
	
	public static EntitegInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EntitegInfo.class);
	}
	
	
	
	public static List<EntitegInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EntitegInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codEntityCateg != null)
			result = result * 31 + (int) codEntityCateg.hashCode();
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EntitegInfo))
			return false;
		
		
		EntitegInfo obj = (EntitegInfo) o;	
		return super.isStringEqual(codEntityCateg, obj.codEntityCateg);
	}
}
