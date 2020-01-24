package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedeekInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public long codCustomer;
	public long codMat;
	public int year;
	public int month;
	public int weekMonth;
	public List<SchedeekdatInfo> schedeekdats;
	public List<StolisInfo> stolises;
	public List<CuslisInfo> cuslises;
	public List<MatlisInfo> matlises;
	public List<EmplisInfo> emplises;
	public String username;
	
	
	public SchedeekInfo() {
		super(SchedeekInfo.class);
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codMat = DefaultValue.number();
		year = DefaultValue.number();
		month = DefaultValue.number();
		weekMonth = DefaultValue.number();
		schedeekdats = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplises = DefaultValue.list();
		cuslises = DefaultValue.list();
	}
	
	
	
	public static SchedeekInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedeekInfo.class);
	}
	
	
	
	public static List<SchedeekInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedeekInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedeekInfo deepCopy = (SchedeekInfo) super.clone();
		
		deepCopy.schedeekdats = cloneSchedeekdat(schedeekdats);
		deepCopy.stolises = cloneStolis(stolises);
		deepCopy.matlises = cloneMat(matlises);
		deepCopy.emplises = cloneEmplis(emplises);
		deepCopy.cuslises = cloneCuslis(cuslises);
		
		return deepCopy;
	}
	
	
	
	private List<SchedeekdatInfo> cloneSchedeekdat(List<SchedeekdatInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<SchedeekdatInfo> results = new ArrayList<>();
		
		for (SchedeekdatInfo eachRecord : recordInfos) {
			SchedeekdatInfo copy = (SchedeekdatInfo) eachRecord.clone();
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
	
	
	
	private List<MatlisInfo> cloneMat(List<MatlisInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<MatlisInfo> results = new ArrayList<>();
		
		for (MatlisInfo eachRecord : recordInfos) {
			MatlisInfo copy = (MatlisInfo) eachRecord.clone();
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
	
	
	
	private List<CuslisInfo> cloneCuslis(List<CuslisInfo> recordInfos) throws CloneNotSupportedException {
		if (recordInfos == null)
			return null;
		
		
		List<CuslisInfo> results = new ArrayList<>();
		
		for (CuslisInfo eachRecord : recordInfos) {
			CuslisInfo copy = (CuslisInfo) eachRecord.clone();
			results.add(copy);
		}
		
		return results;
	}	
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (year 	  	  ^ (year 	 	 >>> 32));
		result = result * 31 + (int) (month	  	  ^ (month 	 	 >>> 32));
		result = result * 31 + (int) (weekMonth	  ^ (weekMonth 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedeekInfo))
			return false;
		
		
		SchedeekInfo obj = (SchedeekInfo) o;		
		return (codOwner    == obj.codOwner		&& 
				codStore    == obj.codStore		&&
				codEmployee == obj.codEmployee	&&
				codCustomer == obj.codCustomer	&&
				codMat 		== obj.codMat		&&
				year    	== obj.year			&&
				month    	== obj.month		&&
				weekMonth   == obj.weekMonth);
	}
}
