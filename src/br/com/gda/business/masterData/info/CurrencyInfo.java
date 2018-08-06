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
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codCurr != null) {
			char[] chars = codCurr.toCharArray();
			
			for (char eachChar : chars) {
				result = result * (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CurrencyInfo))
			return false;
		
		
		CurrencyInfo obj = (CurrencyInfo) o;		
		
		
		if (codCurr == null && obj.codCurr == null)
			return true;
		
		if (codCurr == null || obj.codCurr == null)
			return false;
		
		return codCurr.equals(obj.codCurr);
	}
}
