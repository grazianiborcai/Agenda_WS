package br.com.mind5.payment.customerPartner.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CusparInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayCustomer;
	public int codPayPartner;		
	public long codCustomer;
	public long codCustomerSnapshot;
	public String compoundId;
	public long codUser;
	public long codUserSnapshot;
	public long codAddress;
	public long codAddressSnapshot;
	public long codPhone;
	public long codPhoneSnapshot;
	public PhonapInfo phonapData;
	public AddresnapInfo addresnapData;
	public String customerId;
	public String customerLink;
	public String accountLink;
	public LocalDateTime lastChanged;
	public String username;
	public String recordMode;
	
	
	public CusparInfo() {
		super();
		
		codUser             = DefaultValue.number();
		codOwner            = DefaultValue.number();
		codPhone            = DefaultValue.number();
		recordMode          = DefaultValue.recordMode();
		phonapData			= DefaultValue.object();
		codAddress          = DefaultValue.number();
		codCustomer         = DefaultValue.number();
		addresnapData	    = DefaultValue.object();
		codPayPartner       = DefaultValue.number();
		codPayCustomer      = DefaultValue.number();
		codUserSnapshot     = DefaultValue.number();
		codPhoneSnapshot    = DefaultValue.number();
		codAddressSnapshot  = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
	}
	
	
	
	public static CusparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusparInfo.class);
	}
	
	
	
	public static List<CusparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusparInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();	
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
		
		
		if (!(o instanceof CusparInfo))
			return false;
		
		
		CusparInfo obj = (CusparInfo) o;		
		return (codOwner    	== obj.codOwner 		&& 
				codPayCustomer 	== obj.codPayCustomer 	&&
				codPayPartner 	== obj.codPayPartner 	&&
				codUser     	== obj.codUser				);
	}
}
