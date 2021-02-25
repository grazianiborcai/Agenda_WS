package br.com.mind5.stats.userOrderYearStgn.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusorygeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codOrder;
	public int postingYear;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StusorygeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codOrder = DefaultValue.number();
		codUser = DefaultValue.number();
		postingYear = DefaultValue.number();		
	}
	
	
	
	public static StusorygeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusorygeInfo.class);
	}
	
	
	
	public static List<StusorygeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusorygeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	  ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codOrder 	  ^ (codOrder    >>> 32));
		result = result * 31 + (int) (postingYear ^ (postingYear >>> 32));
		result = result * 31 + (int) (codUser  	  ^ (codUser     >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StusorygeInfo))
			return false;
		
		
		StusorygeInfo obj = (StusorygeInfo) o;		
		return (codOwner    == obj.codOwner &&
				codOrder    == obj.codOrder && 
				codUser     == obj.codUser	&&
				postingYear == obj.postingYear);
	}
}
