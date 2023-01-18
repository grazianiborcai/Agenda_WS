package br.com.mind5.masterData.bankSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankarchInfo extends InfoRecord implements Cloneable {
	public long codBank;
	public String codCountry;
	public String txtCountry;
	public String txtBank;
	public String codCompe;
	
	
	public BankarchInfo() {
		super();
		
		codBank = DefaultValue.number();
	}
	
	
	
	public static BankarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankarchInfo.class);
	}
	
	
	
	public static List<BankarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codBank ^ (codBank >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BankarchInfo))
			return false;
		
		
		BankarchInfo obj = (BankarchInfo) o;		
		return (codBank == obj.codBank);
	}
}
