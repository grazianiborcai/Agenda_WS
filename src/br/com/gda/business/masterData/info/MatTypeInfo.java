package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class MatTypeInfo extends RecordInfo implements Cloneable {
	public int codType;
	public String txtType;
	public String codLanguage;
	
	
	public MatTypeInfo() {
		this.codType = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static MatTypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatTypeInfo.class);
	}
	
	
	
	public static List<MatTypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatTypeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
