package br.com.mind5.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public long codUser;
	public long codOrder;
	public int codPayPartner;
	public String cardCvc;
	public String txtPayPartner;
	public String description;
	public String ownId;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String idTransactionPartner;
	public String statusPaymentPartner;
	public String amountTotalPartner;
	public String amountCurrencyPartner;
	public CusparInfo cusparData;
	public OrderInfo orderData;
	public CrecardInfo crecardData;
	public List<PayordemInfo> payordems;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public PayordInfo() {
		super();
		
		codUser        = DefaultValue.number();
		codOwner       = DefaultValue.number();
		codOrder       = DefaultValue.number();
		orderData      = DefaultValue.object();
		payordems      = DefaultValue.list();
		cusparData     = DefaultValue.object();
		crecardData    = DefaultValue.object();
		codPayOrder    = DefaultValue.number();
		codPayPartner  = DefaultValue.number();
		codCreditCard  = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
	}
	
	
	
	public static PayordInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordInfo.class);
	}
	
	
	
	public static List<PayordInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PayordInfo deepCopy = (PayordInfo) super.clone();
		
		deepCopy.cusparData  = CloneUtil.cloneRecord(cusparData , this.getClass());
		deepCopy.orderData   = CloneUtil.cloneRecord(orderData  , this.getClass());
		deepCopy.crecardData = CloneUtil.cloneRecord(crecardData, this.getClass());
		deepCopy.payordems   = CloneUtil.cloneRecords(payordems , this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		 ^ (codOwner 	 	>>> 32));
		result = result * 31 + (int) (codPayOrder 	 ^ (codPayOrder 	>>> 32));
		result = result * 31 + (int) (codPayPartner  ^ (codPayPartner 	>>> 32));
		result = result * 31 + (int) (codUser 		 ^ (codUser 		>>> 32));
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
				codOrder 	   == obj.codOrder		&&
				codPayCustomer == obj.codPayCustomer	);
	}
}
