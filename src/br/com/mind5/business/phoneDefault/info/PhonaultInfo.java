package br.com.mind5.business.phoneDefault.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PhonaultInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPhone;
	public long codSnapshot;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codUser;
	public long codOwnerRef;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public PhonaultInfo() {
		super();
		
		codUser     = DefaultValue.number();
		codOwner    = DefaultValue.number();
		codPhone    = DefaultValue.number();
		codStore    = DefaultValue.number();
		isDefault   = DefaultValue.boole();
		recordMode  = DefaultValue.recordMode();
		codSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
	}
	
	
	
	public static PhonaultInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhonaultInfo.class);
	}
	
	
	
	public static List<PhonaultInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhonaultInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codPhone 	^ (codPhone 	>>> 32));		
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));
		result = result * 31 + (int) (codUser 		^ (codUser 		>>> 32));
		result = result * 31 + (int) (codOwnerRef 	^ (codOwnerRef	>>> 32));		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhonaultInfo))
			return false;
		
		
		PhonaultInfo obj = (PhonaultInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPhone 	== obj.codPhone	&&
				codCustomer	== obj.codCustomer	&&
				codStore	== obj.codStore		&&
				codEmployee	== obj.codEmployee	&&
				codUser		== obj.codUser		&&
				codOwnerRef	== obj.codOwnerRef);
	}	
}
