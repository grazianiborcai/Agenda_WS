package br.com.mind5.masterData.languageSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class LangarchInfo extends InfoRecord implements Cloneable {
	public String txtLanguage;
	
	
	public LangarchInfo() {
		super();
	}
	
	
	
	public static LangarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, LangarchInfo.class);
	}
	
	
	
	public static List<LangarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, LangarchInfo.class);
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
		
		
		if (!(o instanceof LangarchInfo))
			return false;
		
		
		LangarchInfo obj = (LangarchInfo) o;		
		return isStringEqual(super.codLanguage, obj.codLanguage);
	}
}
