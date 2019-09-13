package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class CurrencyInfo extends InfoRecord implements Cloneable {
	public String codCurr;
	public String txtCurr;
	public String symbolCurr;
	
	
	public CurrencyInfo() {
		super(CurrencyInfo.class);
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
				result = result * 31 + (int) eachChar;
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
		return isStringEqual(codCurr, obj.codCurr);
	}
}
