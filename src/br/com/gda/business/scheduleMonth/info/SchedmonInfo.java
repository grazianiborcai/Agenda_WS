package br.com.gda.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class SchedmonInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public int year;
	public int month;
	public List<SchedonthatInfo> schedonthats;
	public List<StolisInfo> stolises;
	public List<MatInfo> mats;
	public List<EmplisInfo> emplises;
	public String codLanguage;
	public String username;	
	
	
	public SchedmonInfo() {
		super(SchedmonInfo.class);
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		codLanguage = DefaultValue.language();
		schedonthats = DefaultValue.list();
		stolises = DefaultValue.list();
		mats = DefaultValue.list();
		emplises = DefaultValue.list();
	}
	
	
	
	public static SchedmonInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedmonInfo.class);
	}
	
	
	
	public static List<SchedmonInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedmonInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedmonInfo deepCopy = (SchedmonInfo) super.clone();
		
		deepCopy.schedonthats = cloneSchedonthat(schedonthats);
		deepCopy.stolises = cloneStolis(stolises);
		deepCopy.mats = cloneMat(mats);
		deepCopy.emplises = cloneEmplis(emplises);
		
		return deepCopy;
	}
	
	
	
	private List<SchedonthatInfo> cloneSchedonthat(List<SchedonthatInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<SchedonthatInfo> results = new ArrayList<>();
		
		for (SchedonthatInfo eachRecord : recordInfos) {
			SchedonthatInfo copy = (SchedonthatInfo) eachRecord.clone();
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
	
	
	
	private List<MatInfo> cloneMat(List<MatInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<MatInfo> results = new ArrayList<>();
		
		for (MatInfo eachRecord : recordInfos) {
			MatInfo copy = (MatInfo) eachRecord.clone();
			results.add(copy);
		}
		
		return results;
	}	
	
	
	
	private List<EmplisInfo> cloneEmplis(List<EmplisInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<EmplisInfo> results = new ArrayList<>();
		
		for (EmplisInfo eachRecord : recordInfos) {
			EmplisInfo copy = (EmplisInfo) eachRecord.clone();
			results.add(copy);
		}
		
		return results;
	}		
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		result = result * 31 + (int) (month	  	  ^ (month 	 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedmonInfo))
			return false;
		
		
		SchedmonInfo obj = (SchedmonInfo) o;		
		return (codOwner    == obj.codOwner		&& 
				codStore    == obj.codStore		&&
				codEmployee == obj.codEmployee	&&
				codMat 		== obj.codMat		&&
				year    	== obj.year			&&
				month    	== obj.month);
	}
}
