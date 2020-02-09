package br.com.mind5.payment.customerPartnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CusparchInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPayCustomer;	
	public int codPayPartner;		
	public long codCustomer;
	public String compoundId;
	public long codUser;
	public String customerId;
	public String username;
	public String recordMode;
	
	
	public CusparchInfo() {
		super(CusparchInfo.class);
		
		codOwner = DefaultValue.number();	
		codPayPartner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static CusparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusparchInfo.class);
	}
	
	
	
	public static List<CusparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusparchInfo.class);
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
		
		
		if (!(o instanceof CusparchInfo))
			return false;
		
		
		CusparchInfo obj = (CusparchInfo) o;		
		return (codOwner    	== obj.codOwner 		&& 
				codPayCustomer 	== obj.codPayCustomer 	&&
				codPayPartner 	== obj.codPayPartner 	&&
				codUser     	== obj.codUser				);
	}
}
