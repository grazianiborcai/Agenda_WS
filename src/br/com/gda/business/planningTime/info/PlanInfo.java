package br.com.gda.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.RecordInfo;

public final class PlanInfo extends RecordInfo implements Cloneable {
	public List<StoreInfo> stores;
	public List<MatInfo> materials;
	public List<EmpInfo> employees;
	public List<WeekdayInfo> weekdays;
	public List<PlanDataInfo> datas;	
	
	
	public PlanInfo() {
		stores = new ArrayList<>();
		materials = new ArrayList<>();
		employees = new ArrayList<>();
		weekdays = new ArrayList<>();
		datas = new ArrayList<>();
	}
	
	
	
	public static PlanInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanInfo.class);
	}
	
	
	
	public static List<PlanInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException { 
		PlanInfo deepCopy = (PlanInfo) super.clone();
		
		deepCopy.stores = new ArrayList<>();
		deepCopy.materials = new ArrayList<>();
		deepCopy.employees = new ArrayList<>();
		deepCopy.weekdays = new ArrayList<>();
		deepCopy.datas = new ArrayList<>();
		
		
		for (StoreInfo eachStore: stores) {
			StoreInfo clonedInfo = (StoreInfo) eachStore.clone();
			deepCopy.stores.add(clonedInfo);
		}		
		
		for (MatInfo eachMaterial: materials) {
			MatInfo clonedInfo = (MatInfo) eachMaterial.clone();
			deepCopy.materials.add(clonedInfo);
		}
		
		for (EmpInfo eachEmployees: employees) {
			EmpInfo clonedInfo = (EmpInfo) eachEmployees.clone();
			deepCopy.employees.add(clonedInfo);
		}
		
		for (WeekdayInfo eachWeekday: weekdays) {
			WeekdayInfo clonedInfo = (WeekdayInfo) eachWeekday.clone();
			deepCopy.weekdays.add(clonedInfo);
		}
			
		for (PlanDataInfo eachData: datas) {
			PlanDataInfo clonedInfo = (PlanDataInfo) eachData.clone();
			deepCopy.datas.add(clonedInfo);
		}	
		
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;

		if (stores != null)
			result = result * 31 + stores.hashCode();
		
		if (materials != null)
			result = result * 31 + materials.hashCode();
		
		if (employees != null)
			result = result * 31 + employees.hashCode();
		
		if (weekdays != null)
			result = result * 31 + weekdays.hashCode();
		
		if (datas != null)
			result = result * 31 + datas.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanInfo))
			return false;
		
		
		PlanInfo obj = (PlanInfo) o;
		
		return (isStoresEqual(stores, obj.stores)			&&
				isMaterialsEqual(materials, obj.materials) 	&&
				isEmployeesEqual(employees, obj.employees) 	&&
				isWeekdaysEqual(weekdays, obj.weekdays) 	&&
				isDatasEqual(datas, obj.datas));
	}
	
	
	
	private boolean isStoresEqual(List<StoreInfo> storesOne, List<StoreInfo> storesTwo) {
		try {
			if (storesOne == null && storesTwo == null)
				return true;
			
			return storesOne.equals(storesTwo);
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	private boolean isMaterialsEqual(List<MatInfo> materialsOne, List<MatInfo> materialsTwo) {
		try {
			if (materialsOne == null && materialsTwo == null)
				return true;
			
			return materialsOne.equals(materialsTwo);
			
		} catch (Exception e) {
			return false;
		}
	}	
	
	
	
	private boolean isEmployeesEqual(List<EmpInfo> employeesOne, List<EmpInfo> employeesTwo) {
		try {
			if (employeesOne == null && employeesTwo == null)
				return true;
			
			return employeesOne.equals(employeesTwo);
			
		} catch (Exception e) {
			return false;
		}
	}	
	
	
	
	private boolean isWeekdaysEqual(List<WeekdayInfo> weekdaysOne, List<WeekdayInfo> weekdaysTwo) {
		try {
			if (weekdaysOne == null && weekdaysTwo == null)
				return true;
			
			return weekdaysOne.equals(weekdaysTwo);
			
		} catch (Exception e) {
			return false;
		}
	}	
	
	
	
	private boolean isDatasEqual(List<PlanDataInfo> datasOne, List<PlanDataInfo> datasTwo) {
		try {
			if (datasOne == null && datasTwo == null)
				return true;
			
			return datasOne.equals(datasTwo);
			
		} catch (Exception e) {
			return false;
		}
	}	
}
