package br.com.mind5.payment.creditCardSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CrecarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codCreditCard;
	public long codPayCustomer;
	public int codPayPartner;	
	public String creditCardId;
	public String creditCardBrand;
	public String creditCardLast4;
	public long codUser;
	public String recordMode;
	public String username;
	
	
	public CrecarchInfo() {
		super(CrecarchInfo.class);
		
		codOwner = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		codCreditCard = DefaultValue.number();
	}
	
	
	
	public static CrecarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CrecarchInfo.class);
	}
	
	
	
	public static List<CrecarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CrecarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  		^ (codOwner			>>> 32));
		result = result * 31 + (int) (codCreditCard 	^ (codCreditCard 	>>> 32));
		result = result * 31 + (int) (codPayCustomer 	^ (codPayCustomer 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CrecarchInfo))
			return false;
		
		
		CrecarchInfo obj = (CrecarchInfo) o;		
		return (codOwner 		== obj.codOwner 		&& 
				codCreditCard	== obj.codCreditCard	&&
				codPayCustomer	== obj.codPayCustomer		);
	}
}
