package br.com.gda.payment.customerPartner.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.security.userSnapshot.info.UserapInfo;

public final class CusparInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPayCustomer;	
	public int codPayPartner;		
	public long codCustomer;
	public long codCustomerSnapshot;
	public String compoundId;
	public long codUser;
	public long codUserSnapshot;
	public long codAddress;
	public long codAddressSnapshot;
	public long codPhone;
	public long codPhoneSnapshot;
	public String customerId;
	public String customerLink;
	public String accountLink;	
	public SetuparInfo setuparData;
	public UserapInfo userapData;
	public AddresnapInfo addresnapData;
	public PhonapInfo phonapData;
	public LocalDateTime lastChanged;
	public String username;
	public String recordMode;
	
	
	public CusparInfo() {
		super(CusparInfo.class);
		
		codOwner = DefaultValue.number();	
		codPayPartner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		setuparData = DefaultValue.object();
		userapData = DefaultValue.object();
		addresnapData = DefaultValue.object();
		phonapData = DefaultValue.object();
		codAddress = DefaultValue.number();
		codAddressSnapshot = DefaultValue.number();
		codPhone = DefaultValue.number();
		codPhoneSnapshot = DefaultValue.number();
	}
	
	
	
	public static CusparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CusparInfo.class);
	}
	
	
	
	public static List<CusparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CusparInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CusparInfo deepCopy = (CusparInfo) super.clone();		
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
		result = result * 31 + (int) (codUser  			^ (codUser  		>>> 32));
		result = result * 31 + (int) (codPayPartner  	^ (codPayPartner  	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CusparInfo))
			return false;
		
		
		CusparInfo obj = (CusparInfo) o;		
		return (codOwner    	== obj.codOwner 		&& 
				codPayCustomer 	== obj.codPayCustomer 	&&
				codPayPartner 	== obj.codPayPartner 	&&
				codUser     	== obj.codUser				);
	}
}
