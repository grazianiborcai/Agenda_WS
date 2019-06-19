package br.com.gda.payment.masterDataPartner.moip.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class TaxdocmoiptInfo extends InfoRecord implements Cloneable {
	public String type;
	public String number;
	
	
	
	public static TaxdocmoiptInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TaxdocmoiptInfo.class);
	}
	
	
	
	public static List<TaxdocmoiptInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TaxdocmoiptInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TaxdocmoiptInfo))
			return false;
		
		
		TaxdocmoiptInfo obj = (TaxdocmoiptInfo) o;
		return (isStringEqual(obj.type, this.type) 		&&
				isStringEqual(obj.number, this.number)		);
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (type != null)
			result = result * 31 + type.hashCode();
		
		if (number != null)
			result = result * 31 + number.hashCode();
		
		return result;
	}
}
