package br.com.mind5.business.addressSnapshotSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class AddresnaparchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codAddress;
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codStore;
	public long codStoreSnapshot;
	public long codEmployee;
	public long codEmployeeSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public long codOwnerRef;
	public long codOwnerRefSnapshot;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public AddresnaparchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codAddress = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		codOwnerRefSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		isDefault = DefaultValue.boole();
		codUserSnapshot = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static AddresnaparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddresnaparchInfo.class);
	}
	
	
	
	public static List<AddresnaparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddresnaparchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot  >>> 32));
		result = result * 31 + (int) (codAddress 	^ (codAddress 	>>> 32));		
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AddresnaparchInfo))
			return false;
		
		
		AddresnaparchInfo obj = (AddresnaparchInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codSnapshot == obj.codSnapshot 	&& 
				codAddress 	== obj.codAddress	&&
				codCustomer	== obj.codCustomer	&&
				codStore	== obj.codStore		&&
				codEmployee	== obj.codEmployee);
	}	
}
