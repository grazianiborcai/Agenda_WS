package br.com.gda.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public long codUser;				//TODO: manter para check
	public long codOrder;
	public int codPayPartner;
	public String txtPayPartner;
	public String description;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String urlSelf;
	public String urlPayCard;
	public String urlPayBoleto;
	public String amountTotalPartner;
	public String amountCurrencyPartner;
	public SysparInfo sysparData;
	public OrderInfo orderData;
	public CusparInfo cusparData;
	public CrecardInfo crecardData;
	public List<PayordemInfo> payordems;
	public List<OrdmoipInfo> ordmoips;
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
		ordmoips = DefaultValue.list();
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
		deepCopy.ordmoips = cloneOrdmoips(deepCopy.ordmoips);
		
		return deepCopy;
	}
	
	
	
	private OrderInfo cloneOrder(OrderInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (OrderInfo) recordInfo.clone();
	}
	
	
	
	private SysparInfo cloneSyspar(SysparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (SysparInfo) recordInfo.clone();
	}
	
	
	
	private CusparInfo cloneCuspar(CusparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CusparInfo) recordInfo.clone();
	}
	
	
	
	private CrecardInfo cloneCrecard(CrecardInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CrecardInfo) recordInfo.clone();
	}	
	
	
	
	private List<PayordemInfo> clonePayordems(List<PayordemInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PayordemInfo> results = new ArrayList<>();
		
		for (PayordemInfo eachRecord : recordInfos) {
			PayordemInfo cloned = (PayordemInfo) eachRecord.clone();
			results.add(cloned);
		}
		
		return results;
	}
	
	
	
	private List<OrdmoipInfo> cloneOrdmoips(List<OrdmoipInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for (OrdmoipInfo eachRecord : recordInfos) {
			OrdmoipInfo clonedOrdmoip = (OrdmoipInfo) eachRecord.clone();
			results.add(clonedOrdmoip);
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
