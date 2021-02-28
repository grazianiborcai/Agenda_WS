package br.com.mind5.stats.userOrderYearAggr.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusorygrInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public int postingYear;	
	public int countYearTotal;
	public int countYearCreated;
	public int countYearWaiting;
	public int countYearPaid;
	public int countYearPlaced;
	public int countYearCancelled;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public StusorygrInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		postingYear = DefaultValue.number();
		countYearTotal = DefaultValue.number();
		countYearCreated = DefaultValue.number();
		countYearWaiting = DefaultValue.number();
		countYearPaid = DefaultValue.number();
		countYearPlaced = DefaultValue.number();
		countYearCancelled = DefaultValue.number();
	}
	
	
	
	public static StusorygrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusorygrInfo.class);
	}
	
	
	
	public static List<StusorygrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusorygrInfo.class);
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
		
		
		if (!(o instanceof StusorygrInfo))
			return false;
		
		
		StusorygrInfo obj = (StusorygrInfo) o;		
		return (codOwner    == obj.codOwner && 				
				codUser     == obj.codUser	&&
				postingYear == obj.postingYear);
	}
}
