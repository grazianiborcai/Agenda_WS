package br.com.mind5.payment.payOrderItemList.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class PayordemistInfo extends InfoRecord implements Cloneable, Comparable<PayordemistInfo> {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public long codStore;
	public String ownId;
	public String idOrderPartner;
	public String statusOrderPartner;	
	public String idPaymentPartner;	
	public String statusPaymentPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public String itemReceiver;
	public int codPayPartner;
	public String username;	
	
	
	public PayordemistInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codPayOrderItem = DefaultValue.number();	
		codPayOrder = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codStore = DefaultValue.number();
	}
	
	
	
	public static PayordemistInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordemistInfo.class);
	}
	
	
	
	public static List<PayordemistInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordemistInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    		^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codPayOrder 		^ (codPayOrder 		>>> 32));
		result = result * 31 + (int) (codPayOrderItem 	^ (codPayOrderItem 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayordemistInfo))
			return false;
		
		
		PayordemistInfo obj = (PayordemistInfo) o;		
		return (codOwner    	== obj.codOwner    		&& 
				codPayOrder 	== obj.codPayOrder		&&
				codPayOrderItem == obj.codPayOrderItem);
	}


	
	@Override public int compareTo(PayordemistInfo arg0) {
		if (arg0 == null) {
			super.logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		
		if (codPayOrderItem < arg0.codPayOrderItem)
			return -1;
		
		if (codPayOrderItem > arg0.codPayOrderItem)
			return 1;
		
		if (equals(arg0))
			return 0;
		
		
		super.logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);
	}
}
