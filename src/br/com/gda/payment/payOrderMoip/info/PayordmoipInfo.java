package br.com.gda.payment.payOrderMoip.info;

import java.util.List;
import java.util.Map;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordmoipInfo extends InfoRecord implements Cloneable {
	public PayordInfo payordData;
	public Map<String, Object> subtotals;
	public Map<String, Object> amount;
	public List<Map<String, Object>> products;
	
	
	public PayordmoipInfo() {
		payordData = DefaultValue.object();
		products = DefaultValue.list();
	}
	
	
	
	public static PayordmoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordmoipInfo.class);
	}	
	
	
	
	public static List<PayordmoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordmoipInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PayordmoipInfo deepCopy = (PayordmoipInfo) super.clone();		
		deepCopy.payordData = clonePayord(deepCopy.payordData);
		
		return deepCopy;
	}
	
	
	
	private PayordInfo clonePayord(PayordInfo payord) throws CloneNotSupportedException {
		if (payord == null)
			return null;
		
		return (PayordInfo) payord.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (payordData != null)
			result = result * 31 * (payordData.hashCode() ^ (payordData.hashCode() >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayordmoipInfo))
			return false;
		
		
		PayordmoipInfo obj = (PayordmoipInfo) o;		
		return (super.isRecordEqual(this, obj));
	}
}
