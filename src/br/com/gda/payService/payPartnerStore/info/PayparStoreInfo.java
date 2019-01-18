package br.com.gda.payService.payPartnerStore.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayparStoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	
	
	public PayparStoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayparStoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayparStoreInfo.class);
	}
	
	
	
	public static List<PayparStoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayparStoreInfo.class);
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
		
		
		if (!(o instanceof PayparStoreInfo))
			return false;
		
		
		PayparStoreInfo obj = (PayparStoreInfo) o;		
		return (codOwner == obj.codOwner &&
				codStore == obj.codStore	);
	}
}
