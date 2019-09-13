package br.com.gda.webhook.moipRefund.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class WokefumoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public String title;
	public String idPaymentPartner;
	public String username;	
	
	
	public WokefumoipInfo() {
		super(WokefumoipInfo.class);
		
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
	}
	
	
	
	public static WokefumoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, WokefumoipInfo.class);
	}
	
	
	
	public static List<WokefumoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, WokefumoipInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (title != null)		
			result = result * 31 + (int) (title.hashCode() ^ (title.hashCode() >>> 32));
		
		return result;
	}	
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof WokefumoipInfo))
			return false;
		
		
		WokefumoipInfo obj = (WokefumoipInfo) o;		
		return (super.isStringEqual(title, obj.title));
	}
}
