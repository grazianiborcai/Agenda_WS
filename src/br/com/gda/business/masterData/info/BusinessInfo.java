package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class BusinessInfo extends RecordInfo implements Cloneable {
	public int codBusiness;
	public String txtBusiness; 
	public String codLanguage;
	
	
	public BusinessInfo() {
		this.codBusiness = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static BusinessInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BusinessInfo.class);
	}
	
	
	
	public static List<BusinessInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BusinessInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
