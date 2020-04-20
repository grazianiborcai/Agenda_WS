package br.com.mind5.masterData.materialCategory.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MategInfo extends InfoRecord implements Cloneable {
	public int codMatCateg;
	public String txtMatCateg;
	
	
	public MategInfo() {
		super();
		
		codMatCateg = DefaultValue.number();
	}
	
	
	
	public static MategInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MategInfo.class);
	}
	
	
	
	public static List<MategInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MategInfo.class);
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
		
		
		if (!(o instanceof MategInfo))
			return false;
		
		
		MategInfo obj = (MategInfo) o;		
		return (codMatCateg == obj.codMatCateg);
	}
}
