package br.com.mind5.payment.creditCard.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CrecardInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCreditCard;
	public long codPayCustomer;
	public String customerId;
	public int codPayPartner;
	public String txtPayPartner;
	public long codUser;
	public String creditCardId;
	public String creditCardBrand;
	public String creditCardLast4;	
	public String expirationMonth;
	public String expirationYear;
	public boolean isExpired;
	public String cardNumber;
	public String cardCvc;
	public String nameHolder;
	public String birthdateHolder;
	public String cpfHolder;
	public long codPhoneHolder;
	public long codPhoneSnapshotHolder;
	public long codAddressHolder;	
	public long codAddressSnapshotHolder;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public CrecardInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		isExpired = DefaultValue.boole();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		codPhoneHolder = DefaultValue.number();
		codPhoneSnapshotHolder = DefaultValue.number();
		codAddressHolder = DefaultValue.number();
		codAddressSnapshotHolder = DefaultValue.number();
		codCreditCard = DefaultValue.number();
	}
	
	
	
	public static CrecardInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CrecardInfo.class);
	}
	
	
	
	public static List<CrecardInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CrecardInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
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
