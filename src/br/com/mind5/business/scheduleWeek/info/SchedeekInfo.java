package br.com.mind5.business.scheduleWeek.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchedeekInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int weekYear;
	public List<SchedeekdatInfo> schedeekdates;
	public List<StolisInfo> stolises;
	public List<CuslisInfo> cuslises;
	public List<MatlisInfo> matlises;
	public List<EmplresInfo> emplreses;
	public List<CalateInfo> calates;
	public List<CalimoreInfo> calimores;
	public List<CalimempInfo> calimempes;	
	public String username;
	
	
	public SchedeekInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		weekYear = DefaultValue.number();
		schedeekdates = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplreses = DefaultValue.list();
		cuslises = DefaultValue.list();
		calates = DefaultValue.list();
		calimores = DefaultValue.list();
		calimempes = DefaultValue.list();
	}
	
	
	
	public static SchedeekInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedeekInfo.class);
	}
	
	
	
	public static List<SchedeekInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedeekInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedeekInfo deepCopy = (SchedeekInfo) super.clone();
		
		deepCopy.schedeekdates = CloneUtil.cloneRecords(schedeekdates, this.getClass());
		deepCopy.stolises = CloneUtil.cloneRecords(stolises, this.getClass());
		deepCopy.matlises = CloneUtil.cloneRecords(matlises, this.getClass());
		deepCopy.emplreses = CloneUtil.cloneRecords(emplreses, this.getClass());
		deepCopy.cuslises = CloneUtil.cloneRecords(cuslises, this.getClass());
		deepCopy.calates = CloneUtil.cloneRecords(calates, this.getClass());
		deepCopy.calimores = CloneUtil.cloneRecords(calimores, this.getClass());
		deepCopy.calimempes = CloneUtil.cloneRecords(calimempes, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (weekYear	  ^ (weekYear 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedeekInfo))
			return false;
		
		
		SchedeekInfo obj = (SchedeekInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				weekYear == obj.weekYear	);
	}
}
