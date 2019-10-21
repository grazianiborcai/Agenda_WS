package br.com.mind5.business.customerSearch.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CusarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public long codUser;
	public String codEntityCateg;
	public AddressInfo addressData;
	public PhoneInfo phoneData;
	public PersonInfo personData;
	public String recordMode;
	public String username;
	
	
	public CusarchInfo() {
		super(CusarchInfo.class);
		
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		addressData = DefaultValue.object();
		phoneData = DefaultValue.object();
		personData = DefaultValue.object();
	}
	
	
	
	public static CusarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusarchInfo.class);
	}
	
	
	
	public static List<CusarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusarchInfo deepCopy = (CusarchInfo) super.clone();
		
		if (deepCopy.addressData != null)
			deepCopy.addressData = (AddressInfo) deepCopy.addressData.clone();
		
		if (deepCopy.phoneData != null)
			deepCopy.phoneData = (PhoneInfo) deepCopy.phoneData.clone();
		
		if (deepCopy.personData != null)
			deepCopy.personData = (PersonInfo) deepCopy.personData.clone();
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusarchInfo))
			return false;
		
		
		CusarchInfo obj = (CusarchInfo) o;		
		return (codOwner    == obj.codOwner 	&& 
				codCustomer == obj.codCustomer);
	}
}
