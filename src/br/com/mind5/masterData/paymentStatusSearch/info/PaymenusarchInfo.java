package br.com.mind5.masterData.paymentStatusSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class PaymenusarchInfo extends InfoRecord implements Cloneable {
	public String codPaymentStatus;
	public String txtPaymentStatus;
	
	
	public PaymenusarchInfo() {
		super();
	}
	
	
	
	public static PaymenusarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaymenusarchInfo.class);
	}
	
	
	
	public static List<PaymenusarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaymenusarchInfo.class);
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
		
		
		if (!(o instanceof PaymenusarchInfo))
			return false;
		
		
		PaymenusarchInfo obj = (PaymenusarchInfo) o;		
		return (isStringEqual(codPaymentStatus, obj.codPaymentStatus));
	}
}
