package br.com.mind5.business.customerSearch.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CusarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codPerson;
	public long codStore;
	public long codUser;
	public String codEntityCateg;
	public AddressInfo addressData;
	public PersolisInfo persolisData;
	public String recordMode;
	public String username;
	
	
	public CusarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codPerson = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		addressData = DefaultValue.object();
		persolisData = DefaultValue.object();
	}
	
	
	
	public static CusarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusarchInfo.class);
	}
	
	
	
	public static List<CusarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusarchInfo deepCopy = (CusarchInfo) super.clone();
		
		deepCopy.addressData = CloneUtil.cloneRecord(addressData, this.getClass());
		deepCopy.persolisData = CloneUtil.cloneRecord(persolisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codPerson   ^ (codPerson   >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusarchInfo))
			return false;
		
		
		CusarchInfo obj = (CusarchInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codCustomer == obj.codCustomer  &&
				codPerson   == obj.codPerson		);
	}
}
