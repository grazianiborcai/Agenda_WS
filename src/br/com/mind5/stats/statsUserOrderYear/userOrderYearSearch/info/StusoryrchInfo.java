package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

public final class StusoryrchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public int postingYear;	
	public String username;
	public List<StusorygrarchInfo> stusorygrarches;
	public List<StusorylirchInfo> stusorylirches;
	public List<StusorygerchInfo> stusorygerches;
	
	
	public StusoryrchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		postingYear = DefaultValue.number();
		stusorygrarches = DefaultValue.list();
		stusorylirches = DefaultValue.list();
		stusorygerches = DefaultValue.list();
	}
	
	
	
	public static StusoryrchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StusoryrchInfo.class);
	}
	
	
	
	public static List<StusoryrchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StusoryrchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StusoryrchInfo deepCopy = (StusoryrchInfo) super.clone();
		
		deepCopy.stusorygrarches = CloneUtil.cloneRecords(stusorygrarches, this.getClass());
		deepCopy.stusorylirches = CloneUtil.cloneRecords(stusorylirches, this.getClass());
		deepCopy.stusorygerches = CloneUtil.cloneRecords(stusorygerches, this.getClass());
		
		return deepCopy;
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
		
		
		if (!(o instanceof StusoryrchInfo))
			return false;
		
		
		StusoryrchInfo obj = (StusoryrchInfo) o;		
		return (codOwner    == obj.codOwner && 				
				codUser     == obj.codUser	&&
				postingYear == obj.postingYear);
	}
}
