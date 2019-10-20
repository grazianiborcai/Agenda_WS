package br.com.gda.payment.storePartnerList.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class StoplisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codPayPartner;
	public String idPayPartnerStore;
	public String scope;
	public long codSnapshot;
	public String txtPayPartner;
	public String description;
	public String recordMode;
	public String username;
	
	
	public StoplisInfo() {
		super(StoplisInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		codSnapshot = DefaultValue.number();
	}
	
	
	
	public static StoplisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoplisInfo.class);
	}
	
	
	
	public static List<StoplisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoplisInfo.class);
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
		
		
		if (!(o instanceof StoplisInfo))
			return false;
		
		
		StoplisInfo obj = (StoplisInfo) o;		
		return (codOwner	  == obj.codOwner &&
				codStore 	  == obj.codStore &&
				codPayPartner == obj.codPayPartner);
	}
}
