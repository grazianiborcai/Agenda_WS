package br.com.mind5.business.storeProspectCounter.info;

import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoprosouInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int itemCounter;
	public List<StoprosInfo> stoproses;
	public String username;
	
	
	public StoprosouInfo() {
		super();
		
		codOwner = DefaultValue.number();
		itemCounter = DefaultValue.number();
		stoproses = DefaultValue.list();
	}
	
	
	
	public static StoprosouInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoprosouInfo.class);
	}
	
	
	
	public static List<StoprosouInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoprosouInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StoprosouInfo deepCopy = (StoprosouInfo) super.clone();
		
		deepCopy.stoproses = CloneUtil.cloneRecords(stoproses, this.getClass());		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoprosouInfo))
			return false;
		
		
		StoprosouInfo obj = (StoprosouInfo) o;		
		return (codOwner == obj.codOwner);
	}
}
