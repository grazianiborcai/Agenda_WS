package br.com.gda.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public long codUser;				//TODO: manter para check
	public long codCustomer;			//TODO: Remover
	public long codOrder;
	public String feeReceiver;
	public double feeAmount;
	public String codFeeCurrency;
	public String codPaymentStatus;
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	public String codOrderStatus;		//TODO: Remover
	public String txtOrderStatus;		//TODO: Remover
	public long codAddressPay;			//TODO: Remover
	public long codAddressPaySnapshot;	//TODO: Remover
	public long codPhonePay;			//TODO: Remover
	public long codPhonePaySnapshot;	//TODO: Remover
	public AddressInfo addressPayData;	//TODO: Remover
	public PhoneInfo phonePayData;		//TODO: Remover
	public SysparInfo sysparData;
	public OrderInfo orderData;
	public CusparInfo cusparData;
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
		codCustomer = DefaultValue.number();
		codOrder = DefaultValue.number();
		codAddressPay = DefaultValue.number();
		codAddressPaySnapshot = DefaultValue.number();
		codPhonePay = DefaultValue.number();
		codPhonePaySnapshot = DefaultValue.number();
		addressPayData = DefaultValue.object();
		sysparData = DefaultValue.object();
		orderData = DefaultValue.object();
		cusparData = DefaultValue.object();
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
