package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.moip.models.Setup;

public final class CremoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
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
	public AddressInfo addressData;
	public PhoneInfo phoneData;
	public CusparInfo cusparData;
	public SetuparInfo setuparData;
	public Setup setup;
	public Map<String, Object> taxDocument;
	public Map<String, Object> phone;
	public Map<String, Object> billingAddress;
	public Map<String, Object> holder;
	public Map<String, Object> creditCard;
	public Map<String, Object> funding;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String codSysEnviron;
	
	
	public CremoipInfo() {
		super(CremoipInfo.class);
		
		codOwner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		addressData = DefaultValue.object();
		phoneData = DefaultValue.object();
		cusparData = DefaultValue.object();
		setuparData = DefaultValue.object();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static CremoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CremoipInfo.class);
	}
	
	
	
	public static List<CremoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CremoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CremoipInfo deepCopy = (CremoipInfo) super.clone();
		
		deepCopy.setuparData = cloneSetup(deepCopy.setuparData);
		deepCopy.addressData = cloneAddress(deepCopy.addressData);
		deepCopy.phoneData = clonePhone(deepCopy.phoneData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		
		return deepCopy;
	}
	
	
	
	private SetuparInfo cloneSetup(SetuparInfo setupar) throws CloneNotSupportedException {
		if (setupar == null)
			return null;
		
		return (SetuparInfo) setupar.clone();
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
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		if (creditCardId != null)
			result = result * 31 + creditCardId.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CremoipInfo))
			return false;
		
		
		CremoipInfo obj = (CremoipInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(creditCardId, obj.creditCardId));
	}
}
