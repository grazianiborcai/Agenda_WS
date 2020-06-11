package br.com.mind5.masterData.fileDocTypeSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FidocarchInfo extends InfoRecord implements Cloneable {
	public String codFileDocType;
	public String txtFileDocType;
	
	
	public FidocarchInfo() {
		super();
	}
	
	
	
	public static FidocarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FidocarchInfo.class);
	}
	
	
	
	public static List<FidocarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FidocarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codFileDocType != null) {
			char[] chars = codFileDocType.toCharArray();
			
			for (char eachChar : chars) {
				result = result * 31 + (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FidocarchInfo))
			return false;
		
		
		FidocarchInfo obj = (FidocarchInfo) o;
		return isStringEqual(codFileDocType, obj.codFileDocType);
	}
}
