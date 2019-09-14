package br.com.gda.payment.creditCard.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CrecardInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCreditCard;
	public long codPayCustomer;
	public long codPayPartner;
	public long codUser;
	public String creditCardId;
	public String creditCardBrand;
	public String creditCardLast4;	
	public String expirationMonth;
	public String expirationYear;
	public String cardNumber;
	public String cardCvc;
	public String nameHolder;
	public String birthdateHolder;
	public String cpfHolder;
	public long codPhoneHolder;
	public long codPhoneSnapshotHolder;
	public long codAddressHolder;	
	public long codAddressSnapshotHolder;	
	public AddressInfo addressData;
	public PhoneInfo phoneData;
	public CusparInfo cusparData;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public CrecardInfo() {
		super(CrecardInfo.class);
		
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		codPhoneHolder = DefaultValue.number();
		codPhoneSnapshotHolder = DefaultValue.number();
		codAddressHolder = DefaultValue.number();
		codAddressSnapshotHolder = DefaultValue.number();
		addressData = DefaultValue.object();
		phoneData = DefaultValue.object();
		cusparData = DefaultValue.object();
		codCreditCard = DefaultValue.number();
	}
	
	
	
	public static CrecardInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CrecardInfo.class);
	}
	
	
	
	public static List<CrecardInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CrecardInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CrecardInfo deepCopy = (CrecardInfo) super.clone();
		
		deepCopy.addressData = cloneAddress(deepCopy.addressData);
		deepCopy.phoneData = clonePhone(deepCopy.phoneData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		
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
	
	
	
	private CusparInfo cloneCuspar(CusparInfo cuspar) throws CloneNotSupportedException {
		if (cuspar == null)
			return null;
		
		return (CusparInfo) cuspar.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  		^ (codOwner			>>> 32));
		result = result * 31 + (int) (codCreditCard 	^ (codCreditCard 	>>> 32));
		result = result * 31 + (int) (codPayCustomer 	^ (codPayCustomer 	>>> 32));
		
		if (creditCardId != null)
			result = result * 31 + creditCardId.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CrecardInfo))
			return false;
		
		
		CrecardInfo obj = (CrecardInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codCreditCard	== obj.codCreditCard	&&
				codPayCustomer	== obj.codPayCustomer	&&
				super.isStringEqual(creditCardId, obj.creditCardId));
	}
}
