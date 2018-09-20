package br.com.gda.business.fee.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FeeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public char codFeeCateg;
	public String codCurr;
	public double value;
	
	
	public FeeInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codFeeCateg = DefaultValue.character();
		value = DefaultValue.number();
	}
	
	
	
	public static FeeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeeInfo.class);
	}
	
	
	
	public static List<FeeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeeInfo.class);
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
		
		
		if (!(o instanceof FeeInfo))
			return false;
		
		
		FeeInfo obj = (FeeInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore &&
				codFeeCateg == obj.codFeeCateg);
	}
}
