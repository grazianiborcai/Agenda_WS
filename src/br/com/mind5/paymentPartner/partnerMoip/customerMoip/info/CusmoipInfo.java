package br.com.mind5.paymentPartner.partnerMoip.customerMoip.info;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.moip.models.Setup;

public final class CusmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public int codPayPartner;
	public long codPayCustomer;	
	public long codUserSnapshot;	
	public long codAddressSnapshot;	
	public long codPhoneSnapshot;	
	public String compoundId;
	public String customerId;
	public String customerLink;
	public String accountLink;	
	public SetuparInfo setuparData;
	public UserapInfo userapData;
	public AddresnapInfo addresnapData;
	public PhonapInfo phonapData;
	public Setup setup;
	public Map<String, Object> taxDocument;
	public Map<String, Object> phone;
	public Map<String, Object> shippingAddress;
	public Map<String, Object> requestBody;
	public LocalDateTime lastChanged;
	public String username;
	public String codSysEnviron;
	
	
	public CusmoipInfo() {
		super(CusmoipInfo.class);
		
		codOwner = DefaultValue.number();	
		codPayPartner = DefaultValue.number();	
		codPayCustomer = DefaultValue.number();	
		codUserSnapshot = DefaultValue.number();
		codAddressSnapshot = DefaultValue.number();
		codPhoneSnapshot = DefaultValue.number();	
		setuparData = DefaultValue.object();
		userapData = DefaultValue.object();
		addresnapData = DefaultValue.object();
		phonapData = DefaultValue.object();
		codSysEnviron = DefaultValue.getCodEnvironment();
	}
	
	
	
	public static CusmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusmoipInfo.class);
	}
	
	
	
	public static List<CusmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusmoipInfo deepCopy = (CusmoipInfo) super.clone();		
		
		deepCopy.setuparData = cloneSetup(deepCopy.setuparData);
		deepCopy.userapData = cloneUserap(deepCopy.userapData);
		deepCopy.addresnapData = cloneAddresnap(deepCopy.addresnapData);
		deepCopy.phonapData = clonePhonap(deepCopy.phonapData);
		
		return deepCopy;
	}
	
	
	
	private SetuparInfo cloneSetup(SetuparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SetuparInfo) recordInfo.clone();
	}
	
	
	
	private UserapInfo cloneUserap(UserapInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (UserapInfo) recordInfo.clone();
	}
	
	
	
	private AddresnapInfo cloneAddresnap(AddresnapInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (AddresnapInfo) recordInfo.clone();
	}	
	
	
	
	private PhonapInfo clonePhonap(PhonapInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PhonapInfo) recordInfo.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codPayCustomer 	^ (codPayCustomer 	>>> 32));
		
		if (userapData != null)
			result = result * 31 + userapData.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusmoipInfo))
			return false;
		
		
		CusmoipInfo obj = (CusmoipInfo) o;		
		return (codOwner    	== obj.codOwner 		&& 
				codPayCustomer 	== obj.codPayCustomer	&&
				super.isRecordEqual(userapData, obj.userapData));
	}
}
