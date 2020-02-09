package br.com.mind5.payment.customerPartner.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

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
	public long codAddressSnapshot;	//
	public long codPhone;
	public long codPhoneSnapshot;	//
	public String customerId;
	public String customerLink;
	public String accountLink;	
	public SetuparInfo setuparData;	// mover
	public UserapInfo userapData;		// uselis
	public AddresnapInfo addresnapData;	// mover
	public PhonapInfo phonapData; // mover
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
	
	
	
	private SetuparInfo cloneSetup(SetuparInfo recorInfo) throws CloneNotSupportedException {
		if (recorInfo == null)
			return null;
		
		return (SetuparInfo) recorInfo.clone();
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
	
	
	
	private PhonapInfo clonePhonap(PhonapInfo recorInfo) throws CloneNotSupportedException {
		if (recorInfo == null)
			return null;
		
		return (PhonapInfo) recorInfo.clone();
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
