package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayparOwnerInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String codCountry;
	public String txtCountry;
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	public String codLanguage;
	
	
	
	public PayparOwnerInfo() {
		codOwner = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static PayparOwnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayparOwnerInfo.class);
	}
	
	
	
	public static List<PayparOwnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayparOwnerInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner      ^ (codOwner      >>> 32));
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayparOwnerInfo))
			return false;
		
		
		PayparOwnerInfo obj = (PayparOwnerInfo) o;		
		return (codOwner == obj.codOwner && codPayPartner == obj.codPayPartner);
	}
}
