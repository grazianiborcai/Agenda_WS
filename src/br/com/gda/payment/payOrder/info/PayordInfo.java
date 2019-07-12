package br.com.gda.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public long codUser;				//TODO: manter para check
	public long codOrder;
	public String feeReceiver;
	public double feeAmount;
	public String codFeeCurrency;
	public String codPaymentStatus;
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	public SysparInfo sysparData;
	public OrderInfo orderData;
	public CusparInfo cusparData;
	public CrecardInfo crecardData;
	public List<PayordemInfo> payordems;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public String codLanguage;
	public String username;

	
	
	public PayordInfo() {
		codOwner = DefaultValue.number();
		codCreditCard = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codLanguage = DefaultValue.language();
		codUser = DefaultValue.number();
		codOrder = DefaultValue.number();
		sysparData = DefaultValue.object();
		orderData = DefaultValue.object();
		cusparData = DefaultValue.object();
		crecardData = DefaultValue.object();
		payordems = DefaultValue.list();
	}
	
	
	
	public static PayordInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordInfo.class);
	}
	
	
	
	public static List<PayordInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PayordInfo deepCopy = (PayordInfo) super.clone();
		
		deepCopy.orderData = cloneOrder(deepCopy.orderData);
		deepCopy.sysparData = cloneSyspar(deepCopy.sysparData);
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		deepCopy.crecardData = cloneCrecard(deepCopy.crecardData);
		deepCopy.payordems = clonePayordems(deepCopy.payordems);
		
		return deepCopy;
	}
	
	
	
	private OrderInfo cloneOrder(OrderInfo order) throws CloneNotSupportedException {
		if (order == null)
			return null;
		
		return (OrderInfo) order.clone();
	}
	
	
	
	private SysparInfo cloneSyspar(SysparInfo syspar) throws CloneNotSupportedException {
		if (syspar == null)
			return null;
		
		return (SysparInfo) syspar.clone();
	}
	
	
	
	private CusparInfo cloneCuspar(CusparInfo cuspar) throws CloneNotSupportedException {
		if (cuspar == null)
			return null;
		
		return (CusparInfo) cuspar.clone();
	}
	
	
	
	private CrecardInfo cloneCrecard(CrecardInfo crecard) throws CloneNotSupportedException {
		if (crecard == null)
			return null;
		
		return (CrecardInfo) crecard.clone();
	}	
	
	
	
	private List<PayordemInfo> clonePayordems(List<PayordemInfo> payordems) throws CloneNotSupportedException {
		if (payordems == null)
			return null;
		
		List<PayordemInfo> results = new ArrayList<>();
		
		for (PayordemInfo eachPayordem : payordems) {
			PayordemInfo cloned = (PayordemInfo) eachPayordem.clone();
			results.add(cloned);
		}
		
		return results;
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
