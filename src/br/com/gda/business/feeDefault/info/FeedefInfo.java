package br.com.gda.business.feeDefault.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FeedefInfo extends InfoRecord implements Cloneable {
	public char codFeeCateg;
	public String codCurr;
	public double price;
	
	
	public FeedefInfo() {
		super(FeedefInfo.class);
		
		codFeeCateg = DefaultValue.character();
		price = DefaultValue.number();
	}
	
	
	
	public static FeedefInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeedefInfo.class);
	}
	
	
	
	public static List<FeedefInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeedefInfo.class);
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
		
		
		if (!(o instanceof FeedefInfo))
			return false;
		
		
		FeedefInfo obj = (FeedefInfo) o;		
		return (codFeeCateg == obj.codFeeCateg &&
				isStringEqual(codCurr, obj.codCurr));
	}
}
