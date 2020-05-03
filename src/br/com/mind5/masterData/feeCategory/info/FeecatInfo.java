package br.com.mind5.masterData.feeCategory.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FeecatInfo extends InfoRecord implements Cloneable {
	public char codFeeCateg;
	public String txtFeeCateg;
	
	
	public FeecatInfo() {
		super();
		
		codFeeCateg = DefaultValue.character();
	}
	
	
	
	public static FeecatInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeecatInfo.class);
	}
	
	
	
	public static List<FeecatInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeecatInfo.class);
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
		
		
		if (!(o instanceof FeecatInfo))
			return false;
		
		
		FeecatInfo obj = (FeecatInfo) o;		
		return codFeeCateg == obj.codFeeCateg;
	}
}
