package br.com.gda.payment.creditCard.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CrecardInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayCustomer;
	public long codPayPartner;
	public long codUserRef;
	public long codUser;
	public String creditCardId;
	public String creditCardBrand;
	public String creditCardLast4;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String codLanguage;
	
	
	public CrecardInfo() {
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserRef = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
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
				codPayCustomer	== obj.codPayCustomer	&&
				super.isStringEqual(creditCardId, obj.creditCardId));
	}
}
