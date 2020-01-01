package br.com.mind5.payment.storePartnerSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoparchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String idPayPartnerStore;
	public String codePayPartnerStore;
	public String scope;
	public String recordMode;
	public String username;
	
	
	public StoparchInfo() {
		super(StoparchInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StoparchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoparchInfo.class);
	}
	
	
	
	public static List<StoparchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoparchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 		^ (codOwner 	 >>> 32));
		result = result * 31 + (int) (codStore 		^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codPayPartner ^ (codPayPartner >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoparchInfo))
			return false;
		
		
		StoparchInfo obj = (StoparchInfo) o;		
		return (codOwner	  == obj.codOwner &&
				codStore 	  == obj.codStore &&
				codPayPartner == obj.codPayPartner);
	}
}
