package br.com.mind5.masterData.bankAccountType.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankacypeInfo extends InfoRecord implements Cloneable {
	public int codBankAccount;
	public String txtBankAccount;
	
	
	public BankacypeInfo() {
		super();
		
		codBankAccount = DefaultValue.number();
	}
	
	
	
	public static BankacypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankacypeInfo.class);
	}
	
	
	
	public static List<BankacypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankacypeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codBankAccount ^ (codBankAccount >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BankacypeInfo))
			return false;
		
		
		BankacypeInfo obj = (BankacypeInfo) o;		
		return (codBankAccount == obj.codBankAccount);
	}
}
