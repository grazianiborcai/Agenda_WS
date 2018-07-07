package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class CurrencyInfo extends RecordInfo implements Cloneable {
	public String codCurr;
	public String txtCurr;
	public String symbolCurr;
	public String codLanguage;
	
	
	
	public CurrencyInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static CurrencyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CurrencyInfo.class);
	}
	
	
	
	public static List<CurrencyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CurrencyInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
