package br.com.mind5.config.payPartnerConfig.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PayrconfInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String stoparCreation;
	
	
	public PayrconfInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayrconfInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayrconfInfo.class);
	}
	
	
	
	public static List<PayrconfInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayrconfInfo.class);
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
		
		
		if (!(o instanceof PayrconfInfo))
			return false;
		
		
		PayrconfInfo obj = (PayrconfInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
