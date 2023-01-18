package br.com.mind5.masterData.bankHolderTypeSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class BankoldyperchInfo extends InfoRecord implements Cloneable {
	public int codBankHolder;
	public String txtBankHolder;
	
	
	public BankoldyperchInfo() {
		super();
		
		codBankHolder = DefaultValue.number();
	}
	
	
	
	public static BankoldyperchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BankoldyperchInfo.class);
	}
	
	
	
	public static List<BankoldyperchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BankoldyperchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codBankHolder ^ (codBankHolder >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BankoldyperchInfo))
			return false;
		
		
		BankoldyperchInfo obj = (BankoldyperchInfo) o;		
		return (codBankHolder == obj.codBankHolder);
	}
}
