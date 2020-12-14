package br.com.mind5.stats.userStorePurchaseStgn.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusorageInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StusorageInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
	}
	
	
	
	public static StusorageInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusorageInfo.class);
	}
	
	
	
	public static List<StusorageInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusorageInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StusorageInfo))
			return false;
		
		
		StusorageInfo obj = (StusorageInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codUser  == obj.codUser		);
	}
}
