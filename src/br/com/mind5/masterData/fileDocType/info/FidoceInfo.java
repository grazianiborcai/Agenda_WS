package br.com.mind5.masterData.fileDocType.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FidoceInfo extends InfoRecord implements Cloneable {
	public String codFileDocType;
	public String txtFileDocType;
	
	
	public FidoceInfo() {
		super();
	}
	
	
	
	public static FidoceInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FidoceInfo.class);
	}
	
	
	
	public static List<FidoceInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FidoceInfo.class);
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
		
		
		if (!(o instanceof FidoceInfo))
			return false;
		
		
		FidoceInfo obj = (FidoceInfo) o;
		return isStringEqual(codFileDocType, obj.codFileDocType);
	}
}
