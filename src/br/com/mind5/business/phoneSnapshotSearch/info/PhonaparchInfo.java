package br.com.mind5.business.phoneSnapshotSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PhonaparchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codPhone;
	public long codOwnerRef;
	public long codOwnerRefSnapshot;
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codStore;
	public long codStoreSnapshot;
	public long codEmployee;
	public long codEmployeeSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public boolean isDefault;
	public String recordMode;
	public String username;
	
	
	public PhonaparchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPhone = DefaultValue.number();
		codOwnerRef = DefaultValue.number();
		codOwnerRefSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		isDefault = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PhonaparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PhonaparchInfo.class);
	}
	
	
	
	public static List<PhonaparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PhonaparchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	>>> 32));
		result = result * 31 + (int) (codSnapshot	^ (codSnapshot 	>>> 32));
		result = result * 31 + (int) (codPhone 		^ (codPhone 	>>> 32));		
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 	>>> 32));	
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhonaparchInfo))
			return false;
		
		
		PhonaparchInfo obj = (PhonaparchInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codSnapshot		== obj.codSnapshot 		&& 
				codPhone 		== obj.codPhone			&&	
				codCustomer 	== obj.codCustomer 		&&
				codStore		== obj.codStore			&&
				codEmployee		== obj.codEmployee);
	}	
}
