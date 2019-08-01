package br.com.gda.payment.refundOrder.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class RefuInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public PayordInfo payordData;
	public String codLanguage;
	public String username;
	
	
	
	public RefuInfo() {
		codOwner = DefaultValue.number();
		payordData = DefaultValue.object();
		codPayOrder = DefaultValue.number();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static RefuInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefuInfo.class);
	}
	
	
	
	public static List<RefuInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefuInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		RefuInfo deepCopy = (RefuInfo) super.clone();
		
		deepCopy.payordData = clonePayord(deepCopy.payordData);
		
		return deepCopy;
	}
	
	
	
	private PayordInfo clonePayord(PayordInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PayordInfo) recordInfo.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefuInfo))
			return false;
		
		
		RefuInfo obj = (RefuInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codPayOrder == obj.codPayOrder		);
	}
}
