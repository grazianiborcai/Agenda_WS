package br.com.gda.business.feeDefault.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FeeDefaultInfo extends InfoRecord implements Cloneable {
	public char codFeeCateg;
	public String codCurr;
	public double price;
	
	
	public FeeDefaultInfo() {
		codFeeCateg = DefaultValue.character();
		price = DefaultValue.number();
	}
	
	
	
	public static FeeDefaultInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeeDefaultInfo.class);
	}
	
	
	
	public static List<FeeDefaultInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeeDefaultInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		result = result * 31 + (int) (codFeeCateg);
		
		if (codCurr != null)
			result = result * 31 + codCurr.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FeeDefaultInfo))
			return false;
		
		
		FeeDefaultInfo obj = (FeeDefaultInfo) o;		
		return (codFeeCateg == obj.codFeeCateg &&
				isStringEqual(codCurr, obj.codCurr));
	}
}
