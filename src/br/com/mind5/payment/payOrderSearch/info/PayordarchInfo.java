package br.com.mind5.payment.payOrderSearch.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PayordarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public long codOrder;
	public long codUser;
	public int codPayPartner;
	public boolean hasWebhookEvent;
	public String description;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String amountTotalPartner;
	public String amountCurrencyPartner;
	public LocalDateTime createdOn;	
	public LocalDateTime lastChanged;
	public String username;
	
	
	public PayordarchInfo() {
		super();
		
		codUser         = DefaultValue.number();
		codOwner        = DefaultValue.number();
		codOrder        = DefaultValue.number();
		codPayOrder     = DefaultValue.number();
		codCreditCard   = DefaultValue.number();
		codPayPartner   = DefaultValue.number();
		codPayCustomer  = DefaultValue.number();
		hasWebhookEvent = DefaultValue.boole();
	}
	
	
	
	public static PayordarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordarchInfo.class);
	}
	
	
	
	public static List<PayordarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		 ^ (codOwner 	 	>>> 32));
		result = result * 31 + (int) (codPayOrder 	 ^ (codPayOrder 	>>> 32));
		result = result * 31 + (int) (codOrder 		 ^ (codOrder 	 	>>> 32));
		result = result * 31 + (int) (codPayCustomer ^ (codPayCustomer 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayordarchInfo))
			return false;
		
		
		PayordarchInfo obj = (PayordarchInfo) o;		
		return (codOwner	   == obj.codOwner 		&&
				codPayOrder    == obj.codPayOrder 	&&
				codOrder 	   == obj.codOrder		&&
				codPayCustomer == obj.codPayCustomer	);
	}
}
