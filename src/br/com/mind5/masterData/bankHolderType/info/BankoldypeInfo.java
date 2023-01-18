package br.com.mind5.masterData.bankHolderType.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankoldypeInfo extends InfoRecord implements Cloneable {
	public int codBankHolderType;
	public String txtBankHolderType;
	
	
	public BankoldypeInfo() {
		super();
		
		codBankHolderType = DefaultValue.number();
	}
	
	
	
	public static BankoldypeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankoldypeInfo.class);
	}
	
	
	
	public static List<BankoldypeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankoldypeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codBankHolderType ^ (codBankHolderType >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BankoldypeInfo))
			return false;
		
		
		BankoldypeInfo obj = (BankoldypeInfo) o;		
		return (codBankHolderType == obj.codBankHolderType);
	}
}
