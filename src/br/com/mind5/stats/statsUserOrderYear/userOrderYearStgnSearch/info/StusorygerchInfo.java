package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StusorygerchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public int postingYear;
	public String username;
	
	
	public StusorygerchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		postingYear = DefaultValue.number();		
	}
	
	
	
	public static StusorygerchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusorygerchInfo.class);
	}
	
	
	
	public static List<StusorygerchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusorygerchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	  ^ (codOwner    >>> 32));
		result = result * 31 + (int) (postingYear ^ (postingYear >>> 32));
		result = result * 31 + (int) (codUser  	  ^ (codUser     >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StusorygerchInfo))
			return false;
		
		
		StusorygerchInfo obj = (StusorygerchInfo) o;		
		return (codOwner    == obj.codOwner &&
				codUser     == obj.codUser	&&
				postingYear == obj.postingYear);
	}
}
