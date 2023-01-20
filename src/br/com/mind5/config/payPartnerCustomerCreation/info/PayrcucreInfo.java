package br.com.mind5.config.payPartnerCustomerCreation.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PayrcucreInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String cusparCreation;
	
	
	public PayrcucreInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayrcucreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayrcucreInfo.class);
	}
	
	
	
	public static List<PayrcucreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayrcucreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;		
		result = result * 31 + codPayPartner;		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayrcucreInfo))
			return false;
		
		
		PayrcucreInfo obj = (PayrcucreInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
