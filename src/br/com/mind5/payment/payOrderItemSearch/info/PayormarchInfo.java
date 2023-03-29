package br.com.mind5.payment.payOrderItemSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class PayormarchInfo extends InfoRecord implements Cloneable, Comparable<PayormarchInfo> {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public long codOrder;
	public int codOrderItem;
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
	
	
	public PayormarchInfo() {
		super();
		
		codOwner        = DefaultValue.number();
		codOrder        = DefaultValue.number();
		codPayOrder     = DefaultValue.number();
		codOrderItem    = DefaultValue.number();
		codPayPartner   = DefaultValue.number();
		codPayOrderItem = DefaultValue.number();
	}
	
	
	
	public static PayormarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayormarchInfo.class);
	}
	
	
	
	public static List<PayormarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayormarchInfo.class);
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
		
		
		if (!(o instanceof PayormarchInfo))
			return false;
		
		
		PayormarchInfo obj = (PayormarchInfo) o;		
		return (codOwner    	== obj.codOwner    		&& 
				codPayOrder 	== obj.codPayOrder		&&
				codPayOrderItem == obj.codPayOrderItem);
	}


	
	@Override public int compareTo(PayormarchInfo arg0) {
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
