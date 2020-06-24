package br.com.mind5.business.scheduleAuthorization.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedauthInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSchedule;
	public long codStore;
	public long codUser;
	public String username;
	public String recordMode;
	
	
	public SchedauthInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codSchedule = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static SchedauthInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedauthInfo.class);
	}
	
	
	
	public static List<SchedauthInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedauthInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codSchedule ^ (codSchedule >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedauthInfo))
			return false;
		
		
		SchedauthInfo obj = (SchedauthInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codSchedule == obj.codSchedule	&&
				codStore    == obj.codStore			);
	}
}
