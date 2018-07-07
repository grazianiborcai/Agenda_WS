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
}
