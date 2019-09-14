package br.com.gda.business.planningTime.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PlanimeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String username;
	public List<LocalDate> dates;
	public List<StolisInfo> stores;
	public List<MatInfo> materials;
	public List<EmplisInfo> employees;
	public List<WeekdayInfo> weekdays;
	public List<PlanataInfo> planatas;	
	public String codLanguage;
	
	
	public PlanimeInfo() {
		super(PlanimeInfo.class);
		
		codOwner = DefaultValue.number();
		dates = DefaultValue.list();
		stores = DefaultValue.list();
		materials = DefaultValue.list();
		employees = DefaultValue.list();
		weekdays = DefaultValue.list();
		planatas = DefaultValue.list();
		codLanguage = DefaultValue.language();
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
		deepCopy.stores = cloneStores(deepCopy.stores);
		deepCopy.materials = cloneMaterials(deepCopy.materials);
		deepCopy.employees = cloneEmployees(deepCopy.employees);
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
	
	
	
	private List<MatInfo> cloneMaterials(List<MatInfo> materials) throws CloneNotSupportedException {
		if (materials == null)
			return materials;		
		
		List<MatInfo> clones = new ArrayList<>();
		
		for (MatInfo eachMaterial : materials) {
			MatInfo clonedRecord = (MatInfo) eachMaterial.clone();
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

		if (stores != null)
			result = result * 31 + stores.hashCode();
		
		if (materials != null)
			result = result * 31 + materials.hashCode();
		
		if (employees != null)
			result = result * 31 + employees.hashCode();
		
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
				super.isListEqual(stores   , obj.stores)	&&
				super.isListEqual(materials, obj.materials) &&
				super.isListEqual(employees, obj.employees) &&
				super.isListEqual(weekdays , obj.weekdays) 	&&
				super.isListEqual(planatas , obj.planatas));
	}
}
