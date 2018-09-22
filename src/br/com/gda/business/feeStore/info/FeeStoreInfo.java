package br.com.gda.business.feeStore.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FeeStoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public char codFeeCateg;
	public String codCurr;
	public double price;
	
	
	public FeeStoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codFeeCateg = DefaultValue.character();
		price = DefaultValue.number();
	}
	
	
	
	public static FeeStoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeeStoreInfo.class);
	}
	
	
	
	public static List<FeeStoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeeStoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		result = result * 31 + (int) (codFeeCateg);
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FeeStoreInfo))
			return false;
		
		
		FeeStoreInfo obj = (FeeStoreInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				codFeeCateg == obj.codFeeCateg);
	}
}
