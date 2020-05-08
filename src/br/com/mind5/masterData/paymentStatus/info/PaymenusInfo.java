package br.com.mind5.masterData.paymentStatus.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class PaymenusInfo extends InfoRecord implements Cloneable {
	public String codPaymentStatus;
	public String txtPaymentStatus;
	
	
	public PaymenusInfo() {
		super();
	}
	
	
	
	public static PaymenusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaymenusInfo.class);
	}
	
	
	
	public static List<PaymenusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaymenusInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codPaymentStatus == null)
			return 0;
		
		return codPaymentStatus.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PaymenusInfo))
			return false;
		
		
		PaymenusInfo obj = (PaymenusInfo) o;		
		return (isStringEqual(codPaymentStatus, obj.codPaymentStatus));
	}
}
