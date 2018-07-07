package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class TimezoneInfo extends RecordInfo implements Cloneable {
	public String codTimezone;
	public String txtTimezone;
	public String codLanguage;
	
	
	public TimezoneInfo() {
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static TimezoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TimezoneInfo.class);
	}
	
	
	
	public static List<TimezoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TimezoneInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
