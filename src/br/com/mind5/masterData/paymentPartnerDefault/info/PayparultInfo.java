package br.com.mind5.masterData.paymentPartnerDefault.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PayparultInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public boolean isDefault;
	
	
	public PayparultInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
		isDefault = DefaultValue.boole();
	}
	
	
	
	public static PayparultInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayparultInfo.class);
	}
	
	
	
	public static List<PayparultInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayparultInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayparultInfo))
			return false;
		
		
		PayparultInfo obj = (PayparultInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
