package br.com.mind5.business.planningTime.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class PlanimeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String username;
	public List<LocalDate> dates;
	public List<StolisInfo> stolises;
	public List<MatlisInfo> matlises;
	public List<EmplisInfo> emplises;
	public List<WeekdayInfo> weekdays;
	public List<DaypartInfo> dayparts;
	public List<MoonaseInfo> moonases;
	public List<PlanataInfo> planatas;	
	
	
	public PlanimeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		dates = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplises = DefaultValue.list();
		weekdays = DefaultValue.list();
		dayparts = DefaultValue.list();
		moonases = DefaultValue.list();
		planatas = DefaultValue.list();
	}
	
	
	
	public static PlanimeInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanimeInfo.class);
	}
	
	
	
	public static List<PlanimeInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanimeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException { 
		PlanimeInfo deepCopy = (PlanimeInfo) super.clone();
		
		deepCopy.dates = cloneDates(deepCopy.dates);
		deepCopy.stolises = cloneStores(deepCopy.stolises);
		deepCopy.matlises = cloneMaterials(deepCopy.matlises);
		deepCopy.emplises = cloneEmployees(deepCopy.emplises);
		deepCopy.weekdays = cloneWeekdays(deepCopy.weekdays);
		deepCopy.dayparts = cloneDayparts(deepCopy.dayparts);
		deepCopy.moonases = cloneMoonases(deepCopy.moonases);
		deepCopy.planatas = clonePlanatas(deepCopy.planatas);		
		
		return deepCopy;
	}
	
	
	
	private List<LocalDate> cloneDates(List<LocalDate> dates) {
		if (dates == null)
			return dates;	
		
		return new ArrayList<>(dates);
	}
	
	
	
	private List<StolisInfo> cloneStores(List<StolisInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<StolisInfo> clones = new ArrayList<>();
		
		for (StolisInfo eachRecord : infoRecords) {
			StolisInfo clonedRecord = (StolisInfo) eachRecord.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<MatlisInfo> cloneMaterials(List<MatlisInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<MatlisInfo> clones = new ArrayList<>();
		
		for (MatlisInfo eachRecord : infoRecords) {
			MatlisInfo clonedRecord = (MatlisInfo) eachRecord.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<EmplisInfo> cloneEmployees(List<EmplisInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<EmplisInfo> clones = new ArrayList<>();
		
		for (EmplisInfo eachRecord : infoRecords) {
			EmplisInfo clonedRecord = (EmplisInfo) eachRecord.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<WeekdayInfo> cloneWeekdays(List<WeekdayInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<WeekdayInfo> clones = new ArrayList<>();
		
		for (WeekdayInfo eachRecord : infoRecords) {
			WeekdayInfo clonedRecord = (WeekdayInfo) eachRecord.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<DaypartInfo> cloneDayparts(List<DaypartInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<DaypartInfo> clones = new ArrayList<>();
		
		for (DaypartInfo eachRecord : infoRecords) {
			DaypartInfo clonedRecord = (DaypartInfo) eachRecord.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<MoonaseInfo> cloneMoonases(List<MoonaseInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<MoonaseInfo> clones = new ArrayList<>();
		
		for (MoonaseInfo eachRecord : infoRecords) {
			MoonaseInfo clonedRecord = (MoonaseInfo) eachRecord.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<PlanataInfo> clonePlanatas(List<PlanataInfo> infoRecords) throws CloneNotSupportedException {
		if (infoRecords == null)
			return infoRecords;		
		
		List<PlanataInfo> clones = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : infoRecords) {
			PlanataInfo clonedRecord = (PlanataInfo) eachPlanata.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));

		if (stolises != null)
			result = result * 31 + stolises.hashCode();
		
		if (matlises != null)
			result = result * 31 + matlises.hashCode();
		
		if (emplises != null)
			result = result * 31 + emplises.hashCode();
		
		if (weekdays != null)
			result = result * 31 + weekdays.hashCode();
		
		if (planatas != null)
			result = result * 31 + planatas.hashCode();
		
		if (dates != null)
			result = result * 31 + dates.hashCode();
		
		if (dayparts != null)
			result = result * 31 + dayparts.hashCode();
		
		if (moonases != null)
			result = result * 31 + moonases.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanimeInfo))
			return false;
		
		
		PlanimeInfo obj = (PlanimeInfo) o;
		
		return (codOwner == obj.codOwner					&&
				super.isListEqual(stolises , obj.stolises)	&&
				super.isListEqual(matlises , obj.matlises) 	&&
				super.isListEqual(emplises , obj.emplises) 	&&
				super.isListEqual(weekdays , obj.weekdays) 	&&				
				super.isListDateEqual(dates , obj.dates) 	&&
				super.isListEqual(dayparts , obj.dayparts) 	&&
				super.isListEqual(moonases , obj.moonases) 	&&				
				super.isListEqual(planatas , obj.planatas));
	}
}
