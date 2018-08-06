package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class GenderInfo extends RecordInfo implements Cloneable {
	public int codGender;
	public String txtGender;
	public String codLanguage;
	
	
	public GenderInfo() {
		this.codGender = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static GenderInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, GenderInfo.class);
	}
	
	
	
	public static List<GenderInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, GenderInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * (int) (codGender    ^ (codGender    >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof GenderInfo))
			return false;
		
		
		GenderInfo obj = (GenderInfo) o;		
		return (codGender == obj.codGender);
	}
}
