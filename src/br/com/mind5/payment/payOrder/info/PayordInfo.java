package br.com.mind5.payment.payOrder.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class PayordInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public long codPayCustomer;
	public long codCreditCard;
	public long codUser;				//TODO: manter para check
	public long codOrder;
	public int codPayPartner;
	public String cardCvc;
	public String txtPayPartner;
	public String description;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String amountTotalPartner;
	public String amountCurrencyPartner;
	public SysparInfo sysparData;
	public OrderInfo orderData;
	public CusparInfo cusparData;
	public CrecardInfo crecardData;
	public List<PayordemInfo> payordems;
	public List<OrdmoipInfo> ordmoips;
	public PayordarchInfo latestData;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public PayordInfo() {
		super(PayordInfo.class);
		
		codOwner = DefaultValue.number();
		codCreditCard = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codUser = DefaultValue.number();
		codOrder = DefaultValue.number();
		sysparData = DefaultValue.object();
		orderData = DefaultValue.object();
		cusparData = DefaultValue.object();
		crecardData = DefaultValue.object();
		payordems = DefaultValue.list();
		ordmoips = DefaultValue.list();
		latestData = DefaultValue.object();
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
		deepCopy.latestData = cloneLatest(deepCopy.latestData);
		
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
	
	
	
	private PayordarchInfo cloneLatest(PayordarchInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PayordarchInfo) recordInfo.clone();
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
