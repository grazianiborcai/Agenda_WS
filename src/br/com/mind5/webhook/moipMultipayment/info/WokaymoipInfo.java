package br.com.mind5.webhook.moipMultipayment.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class WokaymoipInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPayOrder;
	public String id;
	public String idPaymentPartner;
	public String username;
	
	
	public WokaymoipInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codPayOrder = DefaultValue.number();
	}
	
	
	
	public static WokaymoipInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, WokaymoipInfo.class);
	}
	
	
	
	public static List<WokaymoipInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, WokaymoipInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (id != null)		
			result = result * 31 + (int) (id.hashCode() ^ (id.hashCode() >>> 32));
		
		return result;
	}	
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof WokaymoipInfo))
			return false;
		
		
		WokaymoipInfo obj = (WokaymoipInfo) o;		
		return (super.isStringEqual(id, obj.id));
	}
}
