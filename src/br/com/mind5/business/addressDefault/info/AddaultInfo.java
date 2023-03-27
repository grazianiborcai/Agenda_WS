package br.com.mind5.business.addressDefault.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class AddaultInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codAddress;
	public long codSnapshot;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codUser;
	public long codOwnerRef;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public AddaultInfo() {
		super();

		codUser     = DefaultValue.number();
		codOwner    = DefaultValue.number();
		codStore    = DefaultValue.number();
		isDefault   = DefaultValue.boole();
		recordMode  = DefaultValue.recordMode();
		codAddress  = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codSnapshot = DefaultValue.number();
	}
	
	
	
	public static AddaultInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddaultInfo.class);
	}
	
	
	
	public static List<AddaultInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddaultInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codAddress 	^ (codAddress 	>>> 32));		
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
		
		
		if (!(o instanceof AddaultInfo))
			return false;
		
		
		AddaultInfo obj = (AddaultInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codAddress 	== obj.codAddress	&&
				codCustomer	== obj.codCustomer	&&
				codStore	== obj.codStore		&&
				codEmployee	== obj.codEmployee	&&
				codUser		== obj.codUser		&&
				codOwnerRef	== obj.codOwnerRef);
	}	
}
