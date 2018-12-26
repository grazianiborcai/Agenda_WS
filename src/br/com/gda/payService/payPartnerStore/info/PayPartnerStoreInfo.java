package br.com.gda.payService.payPartnerStore.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayPartnerStoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String txtPayPartner;
	
	
	public PayPartnerStoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayPartnerStoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayPartnerStoreInfo.class);
	}
	
	
	
	public static List<PayPartnerStoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayPartnerStoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayPartnerStoreInfo))
			return false;
		
		
		PayPartnerStoreInfo obj = (PayPartnerStoreInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore	);
	}
}
