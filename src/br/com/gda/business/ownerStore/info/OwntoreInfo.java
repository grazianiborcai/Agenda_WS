package br.com.gda.business.ownerStore.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OwntoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public String username;
	public String recordMode;
	
	
	public OwntoreInfo() {
		super(OwntoreInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static OwntoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwntoreInfo.class);
	}
	
	
	
	public static List<OwntoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwntoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OwntoreInfo))
			return false;
		
		
		OwntoreInfo obj = (OwntoreInfo) o;		
		return (codOwner == obj.codOwner	&&
				codStore == obj.codStore		);
	}	
}
