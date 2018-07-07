package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class LanguInfo extends RecordInfo implements Cloneable {
	public String codLanguage;
	public String txtLanguage;
	
	
	public LanguInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static LanguInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, LanguInfo.class);
	}
	
	
	
	public static List<LanguInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, LanguInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
