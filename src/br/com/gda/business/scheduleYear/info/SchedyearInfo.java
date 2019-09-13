package br.com.gda.business.scheduleYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SchedyearInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int year;
	public List<SchedyeratInfo> schedyerats;
	public List<StolisInfo> stolises;
	public String codLanguage;
	public String username;	
	
	
	public SchedyearInfo() {
		super(SchedyearInfo.class);
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		year = DefaultValue.number();
		codLanguage = DefaultValue.language();
		schedyerats = DefaultValue.list();
		stolises = DefaultValue.list();
	}
	
	
	
	public static SchedyearInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedyearInfo.class);
	}
	
	
	
	public static List<SchedyearInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedyearInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedyearInfo deepCopy = (SchedyearInfo) super.clone();
		deepCopy.schedyerats = cloneSchedyerat(schedyerats);
		deepCopy.stolises = cloneStolis(stolises);
		
		return deepCopy;
	}
	
	
	
	private List<SchedyeratInfo> cloneSchedyerat(List<SchedyeratInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<SchedyeratInfo> results = new ArrayList<>();
		
		for (SchedyeratInfo eachRecord : recordInfos) {
			SchedyeratInfo copy = (SchedyeratInfo) eachRecord.clone();
			results.add(copy);
		}
		
		return results;
	}
	
	
	
	private List<StolisInfo> cloneStolis(List<StolisInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<StolisInfo> results = new ArrayList<>();
		
		for (StolisInfo eachRecord : recordInfos) {
			StolisInfo copy = (StolisInfo) eachRecord.clone();
			results.add(copy);
		}
		
		return results;
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
