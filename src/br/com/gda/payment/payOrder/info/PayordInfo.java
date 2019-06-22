package br.com.gda.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codUser;
	public long codCustomer;
	public long codOrder;
	public long codOrderUser;
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	public String codOrderStatus;
	public String txtOrderStatus;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public String codLanguage;
	public String username;

	
	
	public PayordInfo() {
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codOrder = DefaultValue.number();
		codOrderUser = DefaultValue.number();
	}
	
	
	
	public static PayordInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordInfo.class);
	}
	
	
	
	public static List<PayordInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		 ^ (codOwner 	 	>>> 32));
		result = result * 31 + (int) (codPayOrder 	 ^ (codPayOrder 	>>> 32));
		result = result * 31 + (int) (codPayPartner  ^ (codPayPartner 	>>> 32));
		result = result * 31 + (int) (codUser 		 ^ (codUser 		>>> 32));
		result = result * 31 + (int) (codCustomer 	 ^ (codCustomer 	>>> 32));
		result = result * 31 + (int) (codOrder 		 ^ (codOrder 	 	>>> 32));
		result = result * 31 + (int) (codPayCustomer ^ (codPayCustomer 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayordInfo))
			return false;
		
		
		PayordInfo obj = (PayordInfo) o;		
		return (codOwner	   == obj.codOwner 		&&
				codPayOrder    == obj.codPayOrder 	&&
				codPayPartner  == obj.codPayPartner	&&
				codUser 	   == obj.codUser		&&
				codCustomer    == obj.codCustomer	&&
				codOrder 	   == obj.codOrder		&&
				codPayCustomer == obj.codPayCustomer	);
	}
}
