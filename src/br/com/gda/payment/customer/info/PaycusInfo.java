package br.com.gda.payment.customer.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PaycusInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPayCustomer;	
	public long codPayPartner;		
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String username;
	public String recordMode;
	
	
	
	public PaycusInfo() {
		codOwner = DefaultValue.number();	
		codPayPartner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PaycusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaycusInfo.class);
	}
	
	
	
	public static List<PaycusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaycusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PaycusInfo deepCopy = (PaycusInfo) super.clone();		
		deepCopy.lastChanged = lastChanged;		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codPayCustomer 	^ (codPayCustomer 	>>> 32));
		result = result * 31 + (int) (codUser  			^ (codUser  		>>> 32));
		result = result * 31 + (int) (codPayPartner  	^ (codPayPartner  	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PaycusInfo))
			return false;
		
		
		PaycusInfo obj = (PaycusInfo) o;		
		return (codOwner    	== obj.codOwner 		&& 
				codPayCustomer 	== obj.codPayCustomer 	&&
				codPayPartner 	== obj.codPayPartner 	&&
				codUser     	== obj.codUser				);
	}
}
