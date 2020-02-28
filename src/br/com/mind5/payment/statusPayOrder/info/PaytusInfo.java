package br.com.mind5.payment.statusPayOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class PaytusInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;	
	public long codOrder;
	public long codPayCustomer;	
	public String amountTotalPartner;
	public String amountCurrencyPartner;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public List<PaytusemInfo> paytusems;
	public String username;
	
	
	public PaytusInfo() {
		super(PaytusInfo.class);
		
		codOwner = DefaultValue.number();	
		codPayOrder = DefaultValue.number();
		codOrder = DefaultValue.number();
		codPayCustomer = DefaultValue.number();	
		paytusems = DefaultValue.list();
	}
	
	
	
	public static PaytusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaytusInfo.class);
	}
	
	
	
	public static List<PaytusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaytusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PaytusInfo deepCopy = (PaytusInfo) super.clone();
		
		deepCopy.paytusems = clonePaytusems(deepCopy.paytusems);
		
		return deepCopy;
	}
	
	
	
	private List<PaytusemInfo> clonePaytusems(List<PaytusemInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		List<PaytusemInfo> results = new ArrayList<>();
		
		for(PaytusemInfo eachRecord : recordInfos) {
			PaytusemInfo cloned = (PaytusemInfo) eachRecord.clone();
			results.add(cloned);
		}
		
		return results;
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		
		if (idOrderPartner != null)
			result = result * 31 + (int) (idOrderPartner.hashCode() ^ (idOrderPartner.hashCode() >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PaytusInfo))
			return false;
		
		
		PaytusInfo obj = (PaytusInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codPayOrder == obj.codPayOrder	&&
				super.isStringEqual(idOrderPartner, obj.idOrderPartner));
	}
}
