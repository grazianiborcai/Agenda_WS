package br.com.mind5.masterData.paymentPartner.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PayparInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String txtPayPartner; 
	public String description;
	
	
	public PayparInfo() {
		super();
		
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayparInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayparInfo.class);
	}
	
	
	
	public static List<PayparInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayparInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayparInfo))
			return false;
		
		
		PayparInfo obj = (PayparInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
