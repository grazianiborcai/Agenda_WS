package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MatmovTypeInfo extends InfoRecord implements Cloneable {
	public char codMatmovType;
	public String txtMatmovType;
	public String codLanguage;
	
	
	public MatmovTypeInfo() {
		codMatmovType = DefaultValue.character();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static MatmovTypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatmovTypeInfo.class);
	}
	
	
	
	public static List<MatmovTypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatmovTypeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) codMatmovType;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatmovTypeInfo))
			return false;
		
		
		MatmovTypeInfo obj = (MatmovTypeInfo) o;		
		return (codMatmovType == obj.codMatmovType);
	}
}
