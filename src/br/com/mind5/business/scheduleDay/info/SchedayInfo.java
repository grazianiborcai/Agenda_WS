package br.com.mind5.business.scheduleDay.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class SchedayInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public LocalDate date;
	public List<SchedaytaInfo> schedaytas;
	public List<StolisInfo> stolises;
	public List<MatlisInfo> matlises;
	public List<EmplisInfo> emplises;
	public List<CuslisInfo> cuslises;
	public List<SchedatusInfo> schedatuses;
	public List<MonthInfo> monthes;
	public List<WeekdayInfo> weekdays;
	public List<MooncalInfo> mooncales;
	public String username;	
	
	
	public SchedayInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		date = DefaultValue.object();
		schedaytas = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplises = DefaultValue.list();
		cuslises = DefaultValue.list();
		schedatuses = DefaultValue.list();
		monthes = DefaultValue.list();
		weekdays = DefaultValue.list();
		mooncales = DefaultValue.list();
	}
	
	
	
	public static SchedayInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedayInfo.class);
	}
	
	
	
	public static List<SchedayInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedayInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedayInfo deepCopy = (SchedayInfo) super.clone();
		
		deepCopy.schedaytas = CloneUtil.cloneRecords(schedaytas, this.getClass());
		deepCopy.stolises = CloneUtil.cloneRecords(stolises, this.getClass());
		deepCopy.matlises = CloneUtil.cloneRecords(matlises, this.getClass());
		deepCopy.emplises = CloneUtil.cloneRecords(emplises, this.getClass());
		deepCopy.cuslises = CloneUtil.cloneRecords(cuslises, this.getClass());
		deepCopy.schedatuses = CloneUtil.cloneRecords(schedatuses, this.getClass());
		deepCopy.monthes = CloneUtil.cloneRecords(monthes, this.getClass());
		deepCopy.weekdays = CloneUtil.cloneRecords(weekdays, this.getClass());
		deepCopy.mooncales = CloneUtil.cloneRecords(mooncales, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		
		if (date != null)
			result = result * 31 + date.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedayInfo))
			return false;
		
		
		SchedayInfo obj = (SchedayInfo) o;		
		return (codOwner    == obj.codOwner	&& 
				codStore    == obj.codStore	&&
				super.isDateEqual(date, obj.date));
	}
}
