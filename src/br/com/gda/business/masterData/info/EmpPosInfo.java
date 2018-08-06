package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class EmpPosInfo extends RecordInfo implements Cloneable {
	public long codPosition;
	public String txtPosition;
	public String codLanguage;
	
	
	public EmpPosInfo() {
		this.codPosition = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static EmpPosInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpPosInfo.class);
	}
	
	
	
	public static List<EmpPosInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpPosInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * (int) (codPosition    ^ (codPosition    >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpPosInfo))
			return false;
		
		
		EmpPosInfo obj = (EmpPosInfo) o;		
		return (codPosition == obj.codPosition);
	}
}
