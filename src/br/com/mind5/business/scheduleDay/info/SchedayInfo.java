package br.com.mind5.business.scheduleDay.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedayInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public int year;
	public int month;
	public List<SchedonthatInfo> schedonthats;
	public List<StolisInfo> stolises;
	public List<MatlisInfo> matlises;
	public List<EmplisInfo> emplises;
	public String username;	
	
	
	public SchedayInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		schedonthats = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplises = DefaultValue.list();
	}
	
	
	
	public static SchedayInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedayInfo.class);
	}
	
	
	
	public static List<SchedayInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedayInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedayInfo deepCopy = (SchedayInfo) super.clone();
		
		deepCopy.schedonthats = CloneUtil.cloneRecords(schedonthats, this.getClass());
		deepCopy.stolises = CloneUtil.cloneRecords(stolises, this.getClass());
		deepCopy.matlises = CloneUtil.cloneRecords(matlises, this.getClass());
		deepCopy.emplises = CloneUtil.cloneRecords(emplises, this.getClass());
		
		return deepCopy;
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
		
		
		if (!(o instanceof SchedayInfo))
			return false;
		
		
		SchedayInfo obj = (SchedayInfo) o;		
		return (codOwner    == obj.codOwner		&& 
				codStore    == obj.codStore		&&
				codEmployee == obj.codEmployee	&&
				codMat 		== obj.codMat		&&
				year    	== obj.year			&&
				month    	== obj.month);
	}
}
