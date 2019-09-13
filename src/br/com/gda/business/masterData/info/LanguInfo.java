package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class LanguInfo extends InfoRecord implements Cloneable {
	public String codLanguage;
	public String txtLanguage;
	
	
	public LanguInfo() {
		super(LanguInfo.class);
		
		codLanguage = DefaultValue.language();
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
		
		if (codLanguage != null) {
			char[] chars = codLanguage.toCharArray();
			
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
		return isStringEqual(codLanguage, obj.codLanguage);
	}
}
