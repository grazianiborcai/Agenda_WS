package br.com.mind5.payment.refundOrderItem.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefemInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public long codOrder;
	public int codOrderItem;
	public long codStore;
	public long codPayCustomer;
	public int codPayPartner;
	public String idOrderPartner;
	public String idRefundPartner;
	public String statusRefundPartner;	
	public String itemReceiver;
	public String username;	
	
	
	public RefemInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codPayOrderItem = DefaultValue.number();
		codOrder = DefaultValue.number();	
		codOrderItem = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayCustomer = DefaultValue.number();
		codPayPartner = DefaultValue.number();
	} 
	
	
	
	public static RefemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefemInfo.class);
	}
	
	
	
	public static List<RefemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    		^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codPayOrder 		^ (codPayOrder 		>>> 32));
		result = result * 31 + (int) (codPayOrderItem 	^ (codPayOrderItem	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefemInfo))
			return false;
		
		
		RefemInfo obj = (RefemInfo) o;		
		return (codOwner    	== obj.codOwner    	&& 
				codPayOrder 	== obj.codPayOrder	&&
				codPayOrderItem	== obj.codPayOrderItem			);
	}
}
