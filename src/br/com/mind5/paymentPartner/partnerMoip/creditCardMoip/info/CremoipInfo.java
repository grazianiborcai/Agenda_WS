package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.moip.models.Setup;

public final class CremoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codPayPartner;
	public long codPayCustomer;	
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
	public long codAddressSnapshot;	
	public long codPhoneSnapshot;	
	public AddresnapInfo addresnapData;
	public PhonapInfo phonapData;
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
		super();
		
		codOwner = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codAddressSnapshot = DefaultValue.number();
		codPhoneSnapshot = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		addresnapData = DefaultValue.object();
		phonapData = DefaultValue.object();
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
		
		deepCopy.setuparData   = CloneUtil.cloneRecord(deepCopy.setuparData  , this.getClass());
		deepCopy.addresnapData = CloneUtil.cloneRecord(deepCopy.addresnapData, this.getClass());
		deepCopy.phonapData    = CloneUtil.cloneRecord(deepCopy.phonapData   , this.getClass());
		deepCopy.cusparData    = CloneUtil.cloneRecord(deepCopy.cusparData   , this.getClass());
		
		return deepCopy;
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
