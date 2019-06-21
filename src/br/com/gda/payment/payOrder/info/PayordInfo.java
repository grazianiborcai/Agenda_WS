package br.com.gda.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String idPayPartnerStore;
	public long codSnapshot;
	public String txtPayPartner;
	public String description;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String codLanguage;
	public String username;
	
	
	public PayordInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		codSnapshot = DefaultValue.number();
	}
	
	
	
	public static PayordInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordInfo.class);
	}
	
	
	
	public static List<PayordInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	 >>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayordInfo))
			return false;
		
		
		PayordInfo obj = (PayordInfo) o;		
		return (codOwner	  == obj.codOwner &&
				codStore 	  == obj.codStore &&
				codPayPartner == obj.codPayPartner);
	}
}
