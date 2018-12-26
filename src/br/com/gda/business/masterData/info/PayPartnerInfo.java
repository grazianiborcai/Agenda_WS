package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PayPartnerInfo extends InfoRecord implements Cloneable {
	public int codPayPartner;
	public String txtPayPartner; 
	public String description;
	
	
	public PayPartnerInfo() {
		codPayPartner = DefaultValue.number();
	}
	
	
	
	public static PayPartnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayPartnerInfo.class);
	}
	
	
	
	public static List<PayPartnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayPartnerInfo.class);
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
		
		
		if (!(o instanceof PayPartnerInfo))
			return false;
		
		
		PayPartnerInfo obj = (PayPartnerInfo) o;		
		return (codPayPartner == obj.codPayPartner);
	}
}
