package br.com.mind5.masterData.language.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class LanguInfo extends InfoRecord implements Cloneable {
	public String txtLanguage;
	public String recordMode;
	
	
	public LanguInfo() {
		super();
		
		recordMode = DefaultValue.recordMode();
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
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (super.codLanguage != null) {
			char[] chars = super.codLanguage.toCharArray();
			
			for (char eachChar : chars) {
				result = result * 31 + (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof LanguInfo))
			return false;
		
		
		LanguInfo obj = (LanguInfo) o;		
		return isStringEqual(super.codLanguage, obj.codLanguage);
	}
}
