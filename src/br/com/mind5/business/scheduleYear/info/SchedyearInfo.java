package br.com.mind5.business.scheduleYear.info;

import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.month.info.MonthInfo;

public final class SchedyearInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int year;
	public List<SchedyeratInfo> schedyerates;
	public List<StolisInfo> stolises;
	public List<MonthInfo> monthes;
	public String username;
	
	
	public SchedyearInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		schedyerates = DefaultValue.list();
		stolises = DefaultValue.list();
		monthes = DefaultValue.list();
	}
	
	
	
	public static SchedyearInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedyearInfo.class);
	}
	
	
	
	public static List<SchedyearInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedyearInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedyearInfo deepCopy = (SchedyearInfo) super.clone();
		
		deepCopy.schedyerates = CloneUtil.cloneRecords(schedyerates, this.getClass());
		deepCopy.stolises = CloneUtil.cloneRecords(stolises, this.getClass());
		deepCopy.monthes = CloneUtil.cloneRecords(monthes, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedyearInfo))
			return false;
		
		
		SchedyearInfo obj = (SchedyearInfo) o;		
		return (codOwner    == obj.codOwner	&& 
				codStore    == obj.codStore	&&
				year    	== obj.year			);
	}
}
