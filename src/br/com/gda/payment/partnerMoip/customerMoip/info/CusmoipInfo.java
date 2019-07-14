package br.com.gda.payment.partnerMoip.customerMoip.info;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.moip.models.Setup;

public final class CusmoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPayCustomer;	
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
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String username;
	
	
	
	public CusmoipInfo() {
		codOwner = DefaultValue.number();	
		codPayCustomer = DefaultValue.number();	
		codLanguage = DefaultValue.language();
		setuparData = DefaultValue.object();
		userapData = DefaultValue.object();
		addresnapData = DefaultValue.object();
		phonapData = DefaultValue.object();
	}
	
	
	
	public static CusmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusmoipInfo.class);
	}
	
	
	
	public static List<CusmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusmoipInfo deepCopy = (CusmoipInfo) super.clone();		
		deepCopy.lastChanged = lastChanged;		
		
		deepCopy.setuparData = cloneSetup(deepCopy.setuparData);
		deepCopy.userapData = cloneUserap(deepCopy.userapData);
		deepCopy.addresnapData = cloneAddresnap(deepCopy.addresnapData);
		deepCopy.phonapData = clonePhonap(deepCopy.phonapData);
		return deepCopy;
	}
	
	
	
	private SetuparInfo cloneSetup(SetuparInfo setupar) throws CloneNotSupportedException {
		if (setupar == null)
			return null;
		
		return (SetuparInfo) setupar.clone();
	}
	
	
	
	private UserapInfo cloneUserap(UserapInfo userap) throws CloneNotSupportedException {
		if (userap == null)
			return null;
		
		return (UserapInfo) userap.clone();
	}
	
	
	
	private AddresnapInfo cloneAddresnap(AddresnapInfo addresnap) throws CloneNotSupportedException {
		if (addresnap == null)
			return null;
		
		return (AddresnapInfo) addresnap.clone();
	}	
	
	
	
	private PhonapInfo clonePhonap(PhonapInfo phonap) throws CloneNotSupportedException {
		if (phonap == null)
			return null;
		
		return (PhonapInfo) phonap.clone();
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
