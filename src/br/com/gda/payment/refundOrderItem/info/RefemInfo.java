package br.com.gda.payment.refundOrderItem.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class RefemInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public int itemNum;
	public long codPayCustomer;
	public String idOrderPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public CusparInfo cusparData;
	public String codLanguage;
	public String username;
	
	
	
	public RefemInfo() {
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		itemNum = DefaultValue.number();
		codPayCustomer = DefaultValue.object();
		cusparData = DefaultValue.object();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static RefemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefemInfo.class);
	}
	
	
	
	public static List<RefemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		RefemInfo deepCopy = (RefemInfo) super.clone();
		
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
		result = result * 31 + (int) (itemNum 	  ^ (itemNum 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefemInfo))
			return false;
		
		
		RefemInfo obj = (RefemInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codPayOrder == obj.codPayOrder	&&
				itemNum    	== obj.itemNum			);
	}
}
