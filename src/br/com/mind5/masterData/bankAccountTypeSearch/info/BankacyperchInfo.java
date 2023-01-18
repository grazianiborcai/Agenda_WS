package br.com.mind5.masterData.bankAccountTypeSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankacyperchInfo extends InfoRecord implements Cloneable {
	public int codBankAccountType;
	public String txtBankAccountType;
	
	
	public BankacyperchInfo() {
		super();
		
		codBankAccountType = DefaultValue.number();
	}
	
	
	
	public static BankacyperchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankacyperchInfo.class);
	}
	
	
	
	public static List<BankacyperchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankacyperchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codBankAccountType ^ (codBankAccountType >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BankacyperchInfo))
			return false;
		
		
		BankacyperchInfo obj = (BankacyperchInfo) o;		
		return (codBankAccountType == obj.codBankAccountType);
	}
}
