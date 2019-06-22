package br.com.gda.payment.customerPartner.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class CusparInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPayCustomer;	
	public long codPayPartner;		
	public long codCustomer;
	public long codCustomerSnapshot;
	public long codUser;
	public long codUserSnapshot;
	public SetuparInfo setuparData;
	public UserapInfo userapData;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String username;
	public String recordMode;
	
	
	
	public CusparInfo() {
		codOwner = DefaultValue.number();	
		codPayPartner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		setuparData = DefaultValue.object();
		userapData = DefaultValue.object();
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
