package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class PaymentStatusInfo extends InfoRecord implements Cloneable {
	public String codPaymentStatus;
	public String txtPaymentStatus;
	
	
	public PaymentStatusInfo() {
		super(PaymentStatusInfo.class);
	}
	
	
	
	public static PaymentStatusInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PaymentStatusInfo.class);
	}
	
	
	
	public static List<PaymentStatusInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PaymentStatusInfo.class);
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
		
		
		if (!(o instanceof PaymentStatusInfo))
			return false;
		
		
		PaymentStatusInfo obj = (PaymentStatusInfo) o;		
		return (isStringEqual(codPaymentStatus, obj.codPaymentStatus));
	}
}
