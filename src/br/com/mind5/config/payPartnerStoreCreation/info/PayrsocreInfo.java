package br.com.mind5.config.payPartnerStoreCreation.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PayrsocreInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String stoparCreation;
	
	
	public PayrsocreInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayrsocreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayrsocreInfo.class);
	}
	
	
	
	public static List<PayrsocreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayrsocreInfo.class);
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
		
		
		if (!(o instanceof PayrsocreInfo))
			return false;
		
		
		PayrsocreInfo obj = (PayrsocreInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
