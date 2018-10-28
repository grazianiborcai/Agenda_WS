package br.com.gda.business.customer.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public String cpf;
	public String name;
	public int codGender;
	public String txtGender;
	public LocalDate birthDate;
	public String email;
	public int codCountryPhone1;
	public String phoneNumber1;	
	public List<AddressInfo> addresses;
	public String codLanguage;
	public String recordMode;
	
	
	public CusInfo() {
		codOwner = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codGender = DefaultValue.gender();
		codCountryPhone1 = DefaultValue.number();
		addresses = new ArrayList<>();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
	}
	
	
	
	public static CusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusInfo.class);
	}
	
	
	
	public static List<CusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
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
		
		
		if (!(o instanceof CusInfo))
			return false;
		
		
		CusInfo obj = (CusInfo) o;		
		return (codOwner == obj.codOwner && codCustomer == obj.codCustomer);
	}
}
