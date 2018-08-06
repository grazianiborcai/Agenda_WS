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

		result = result + stores.hashCode();
		result = result + materials.hashCode();
		result = result + employees.hashCode();
		result = result + weekdays.hashCode();
		result = result + datas.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanInfo))
			return false;
		
		
		PlanInfo obj = (PlanInfo) o;	
		
		return (stores.equals(obj.stores) &&
				materials.equals(obj.materials) &&
				employees.equals(obj.employees) &&
				weekdays.equals(obj.weekdays) &&
				datas.equals(obj.datas));
	}
}
