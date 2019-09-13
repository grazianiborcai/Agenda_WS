package br.com.gda.payment.statusPayOrderItem.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class PaytusemInfo extends InfoRecord implements Cloneable, Comparable<PaytusemInfo> {
	public long codOwner;
	public long codPayOrder;	
	public int codPayOrderItem;
	public double totitem;
	public String codCurr;
	public String idOrderPartner;
	public String statusOrderPartner;
	public String idPaymentPartner;
	public String statusPaymentPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public CusparInfo cusparData;
	public String username;
	
	
	public PaytusemInfo() {
		super(PaytusemInfo.class);
		
		codOwner = DefaultValue.number();	
		codPayOrderItem = DefaultValue.number();	
		totitem = DefaultValue.number();	
		cusparData = DefaultValue.object();
	}
	
	
	
	public static PaytusemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaytusemInfo.class);
	}
	
	
	
	public static List<PaytusemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaytusemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PaytusemInfo deepCopy = (PaytusemInfo) super.clone();
		
		deepCopy.cusparData = cloneCuspar(deepCopy.cusparData);
		
		return deepCopy;
	}
	
	
	
	private CusparInfo cloneCuspar(CusparInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (CusparInfo) recordInfo.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		result = result * 31 + (int) (codPayOrderItem 	  ^ (codPayOrderItem 	 >>> 32));
		
		if (idOrderPartner != null)
			result = result * 31 + (int) (idOrderPartner.hashCode() ^ (idOrderPartner.hashCode() >>> 32));
		
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
				codPayOrderItem    	== obj.codPayOrderItem		&&
				super.isStringEqual(idOrderPartner, obj.idOrderPartner));
	}
	
	
	
	@Override public int compareTo(PaytusemInfo arg0) {
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
