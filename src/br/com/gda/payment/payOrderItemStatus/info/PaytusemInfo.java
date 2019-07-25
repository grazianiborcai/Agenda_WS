package br.com.gda.payment.payOrderItemStatus.info;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class PaytusemInfo extends InfoRecord implements Cloneable, Comparable<PaytusemInfo> {
	public long codOwner;
	public long codPayOrder;
	public int itemNum;
	public double totitem;
	public String codCurr;
	public String statusOrderPartner;
	public String statusPaymentPartner;
	public String codLanguage;
	public String username;
	
	
	public PaytusemInfo() {
		codOwner = DefaultValue.number();	
		itemNum = DefaultValue.number();	
		totitem = DefaultValue.number();	
	}
	
	
	
	public static PaytusemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaytusemInfo.class);
	}
	
	
	
	public static List<PaytusemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaytusemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		result = result * 31 + (int) (itemNum 	  ^ (itemNum 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PaytusemInfo))
			return false;
		
		
		PaytusemInfo obj = (PaytusemInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codPayOrder == obj.codPayOrder	&&
				itemNum    	== obj.itemNum			);
	}
	
	
	
	@Override public int compareTo(PaytusemInfo arg0) {
		if (arg0 == null) {
			logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		
		if (itemNum < arg0.itemNum)
			return -1;
		
		if (itemNum > arg0.itemNum)
			return 1;
		
		if (equals(arg0))
			return 0;
		
		
		logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
