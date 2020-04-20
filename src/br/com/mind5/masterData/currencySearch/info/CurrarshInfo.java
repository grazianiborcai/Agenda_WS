package br.com.mind5.masterData.currencySearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class CurrarshInfo extends InfoRecord implements Cloneable {
	public String codCurr;
	public String txtCurr;
	public String symbolCurr;
	
	
	public CurrarshInfo() {
		super();
	}
	
	
	
	public static CurrarshInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CurrarshInfo.class);
	}
	
	
	
	public static List<CurrarshInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CurrarshInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codCurr != null) {
			char[] chars = codCurr.toCharArray();
			
			for (char eachChar : chars) {
				result = result * 31 + (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CurrarshInfo))
			return false;
		
		
		CurrarshInfo obj = (CurrarshInfo) o;		
		return isStringEqual(codCurr, obj.codCurr);
	}
}
