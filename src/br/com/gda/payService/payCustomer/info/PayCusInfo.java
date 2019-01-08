package br.com.gda.payService.payCustomer.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayCusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayCustomer;
	public String codPayCustomerExt;
	public int codPayPartner;
	public long codUser;
	public long codPerson;
	public long codPersonRef;
	public long codPhoneRef;
	public long codAddressRef;
	public String codCountry;
	public String cpf;
	public String name;
	public String codEntityCateg;
	public int codGender;
	public String txtGender;
	public LocalDate birthDate;
	public String email;
	public AddressInfo address;
	public PhoneInfo phone;
	public String codLanguage;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	public PayCusInfo() {
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codUser = DefaultValue.number();
		codPerson = DefaultValue.number();
		codPersonRef = DefaultValue.number();
		codAddressRef = DefaultValue.number();
		codPhoneRef = DefaultValue.number();
		codGender = DefaultValue.gender();
		address = DefaultValue.object();
		phone = DefaultValue.object();
		codLanguage = DefaultValue.language();		
		recordMode = DefaultValue.recordMode();		
	}
	
	
	
	public static PayCusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayCusInfo.class);
	}
	
	
	
	public static List<PayCusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayCusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PayCusInfo deepCopy = (PayCusInfo) super.clone();
		
		deepCopy.address = cloneAddress(deepCopy.address);
		deepCopy.phone = clonePhone(deepCopy.phone);
		
		return deepCopy;
	}
	
	
	
	private AddressInfo cloneAddress(AddressInfo address) throws CloneNotSupportedException {
		if (address == null)
			return null;
		
		return (AddressInfo) address.clone();
	}
	
	
	
	private PhoneInfo clonePhone(PhoneInfo phone) throws CloneNotSupportedException {
		if (phone == null)
			return null;
		
		return (PhoneInfo) phone.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayCustomer ^ (codPayCustomer >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayCusInfo))
			return false;
		
		
		PayCusInfo obj = (PayCusInfo) o;		
		return (codOwner == obj.codOwner && codPayCustomer == obj.codPayCustomer);
	}
}
