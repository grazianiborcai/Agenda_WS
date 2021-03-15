package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusorygrarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public int postingYear;	
	public String username;
	
	
	public StusorygrarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		postingYear = DefaultValue.number();
	}
	
	
	
	public static StusorygrarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusorygrarchInfo.class);
	}
	
	
	
	public static List<StusorygrarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusorygrarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	  ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codUser  	  ^ (codUser     >>> 32));
		result = result * 31 + (int) (postingYear ^ (postingYear >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StusorygrarchInfo))
			return false;
		
		
		StusorygrarchInfo obj = (StusorygrarchInfo) o;		
		return (codOwner    == obj.codOwner && 				
				codUser     == obj.codUser	&&
				postingYear == obj.postingYear);
	}
}
