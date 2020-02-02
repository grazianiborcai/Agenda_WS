package br.com.mind5.business.planningTime.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PlanimeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String username;
	public List<LocalDate> dates;
	public List<StolisInfo> stolises;
	public List<MatlisInfo> matlises;
	public List<EmplisInfo> emplises;
	public List<WeekdayInfo> weekdays;
	public List<PlanataInfo> planatas;	
	
	
	public PlanimeInfo() {
		super(PlanimeInfo.class);
		
		codOwner = DefaultValue.number();
		dates = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplises = DefaultValue.list();
		weekdays = DefaultValue.list();
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
		deepCopy.planatas = clonePlanatas(deepCopy.planatas);		
		
		return deepCopy;
	}
	
	
	
	private List<LocalDate> cloneDates(List<LocalDate> dates) {
		if (dates == null)
			return dates;	
		
		return new ArrayList<>(dates);
	}
	
	
	
	private List<StolisInfo> cloneStores(List<StolisInfo> stores) throws CloneNotSupportedException {
		if (stores == null)
			return stores;		
		
		List<StolisInfo> clones = new ArrayList<>();
		
		for (StolisInfo eachStore : stores) {
			StolisInfo clonedRecord = (StolisInfo) eachStore.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<MatlisInfo> cloneMaterials(List<MatlisInfo> materials) throws CloneNotSupportedException {
		if (materials == null)
			return materials;		
		
		List<MatlisInfo> clones = new ArrayList<>();
		
		for (MatlisInfo eachMaterial : materials) {
			MatlisInfo clonedRecord = (MatlisInfo) eachMaterial.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<EmplisInfo> cloneEmployees(List<EmplisInfo> employees) throws CloneNotSupportedException {
		if (employees == null)
			return employees;		
		
		List<EmplisInfo> clones = new ArrayList<>();
		
		for (EmplisInfo eachEmployee : employees) {
			EmplisInfo clonedRecord = (EmplisInfo) eachEmployee.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<WeekdayInfo> cloneWeekdays(List<WeekdayInfo> weekdays) throws CloneNotSupportedException {
		if (weekdays == null)
			return weekdays;		
		
		List<WeekdayInfo> clones = new ArrayList<>();
		
		for (WeekdayInfo eachWeekday : weekdays) {
			WeekdayInfo clonedRecord = (WeekdayInfo) eachWeekday.clone();
			clones.add(clonedRecord);
		}
		
		return clones;
	}
	
	
	
	private List<PlanataInfo> clonePlanatas(List<PlanataInfo> planatas) throws CloneNotSupportedException {
		if (planatas == null)
			return planatas;		
		
		List<PlanataInfo> clones = new ArrayList<>();
		
		for (PlanataInfo eachPlanata : planatas) {
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
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanimeInfo))
			return false;
		
		
		PlanimeInfo obj = (PlanimeInfo) o;
		
		return (codOwner == obj.codOwner					&&
				super.isListEqual(stolises   , obj.stolises)	&&
				super.isListEqual(matlises, obj.matlises) &&
				super.isListEqual(emplises, obj.emplises) &&
				super.isListEqual(weekdays , obj.weekdays) 	&&
				super.isListEqual(planatas , obj.planatas));
	}
}
