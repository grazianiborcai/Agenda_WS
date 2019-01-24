package br.com.gda.payPartner.moip.moipMasterData.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class TaxDocumentInfo extends InfoRecord implements Cloneable {
	public String type;
	public String number;
	
	
	
	public static TaxDocumentInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TaxDocumentInfo.class);
	}
	
	
	
	public static List<TaxDocumentInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TaxDocumentInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TaxDocumentInfo))
			return false;
		
		
		TaxDocumentInfo obj = (TaxDocumentInfo) o;
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
