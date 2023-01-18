package br.com.mind5.masterData.bank.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankInfo extends InfoRecord implements Cloneable {
	public long codBank;
	public String codCountry;
	public String txtCountry;
	public String txtBank;
	public String codCompe;
	
	
	public BankInfo() {
		super();
		
		codBank = DefaultValue.number();
	}
	
	
	
	public static BankInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankInfo.class);
	}
	
	
	
	public static List<BankInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankInfo.class);
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
		
		
		if (!(o instanceof BankInfo))
			return false;
		
		
		BankInfo obj = (BankInfo) o;		
		return (codBank == obj.codBank);
	}
}
