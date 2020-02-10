package br.com.mind5.payment.partnerMoip.customerMoip.info;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.moip.models.Setup;

public final class CusmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public int codPayPartner;
	public long codPayCustomer;	
	public long codUser;	
	public long codAddress;	
	public long codPhone;	
	public String compoundId;
	public String customerId;
	public String customerLink;
	public String accountLink;	
	public SetuparInfo setuparData;
	public UselisInfo uselisData;
	public AddressInfo addressData;
	public PhoneInfo phoneData;
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
		codUser = DefaultValue.number();	
		codAddress = DefaultValue.number();	
		codPhone = DefaultValue.number();	
		setuparData = DefaultValue.object();
		uselisData = DefaultValue.object();
		addressData = DefaultValue.object();
		phoneData = DefaultValue.object();
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
		deepCopy.uselisData = cloneUselis(deepCopy.uselisData);
		deepCopy.addressData = cloneAddress(deepCopy.addressData);
		deepCopy.phoneData = clonePhone(deepCopy.phoneData);
		
		return deepCopy;
	}
	
	
	
	private SetuparInfo cloneSetup(SetuparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SetuparInfo) recordInfo.clone();
	}
	
	
	
	private UselisInfo cloneUselis(UselisInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (UselisInfo) recordInfo.clone();
	}
	
	
	
	private AddressInfo cloneAddress(AddressInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (AddressInfo) recordInfo.clone();
	}	
	
	
	
	private PhoneInfo clonePhone(PhoneInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PhoneInfo) recordInfo.clone();
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 			^ (codOwner 		>>> 32));
		result = result * 31 + (int) (codPayCustomer 	^ (codPayCustomer 	>>> 32));
		
		if (uselisData != null)
			result = result * 31 + uselisData.hashCode();
		
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
				super.isRecordEqual(uselisData, obj.uselisData));
	}
}
