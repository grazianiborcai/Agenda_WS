package br.com.gda.business.employeeWorkTime.info;

import java.time.LocalTime;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public class EmpWTimeInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public String codLanguage;
	public String recordMode;
	
	
	public EmpWTimeInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codWeekday = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public OwnerInfo toOwnerInfo() {
		OwnerInfo owner = new OwnerInfo();
		owner.codOwner = codOwner;
		owner.codLanguage = codLanguage;
		return owner;
	}
	
	
	
	public StoreInfo toStoreInfo() {
		StoreInfo store = new StoreInfo();
		store.codOwner = codOwner;
		store.codStore = codStore;
		store.codLanguage = codLanguage;
		return store;
	}
	
	
	
	public EmpInfo toEmpInfo() {
		EmpInfo emp = new EmpInfo();
		emp.codOwner = codOwner;
		emp.codEmployee = codEmployee;
		emp.codLanguage = codLanguage;
		return emp;
	}
	
	
	
	public StoreEmpInfo toStoreEmpInfo() {
		StoreEmpInfo storeEmp = new StoreEmpInfo();
		storeEmp.codOwner = codOwner;
		storeEmp.codStore = codStore;
		storeEmp.codEmployee = codEmployee;
		storeEmp.codLanguage = codLanguage;
		return storeEmp;
	}
	
	
	
	public WeekdayInfo toWeekdayInfo() {
		WeekdayInfo store = new WeekdayInfo();
		store.codWeekday = codWeekday;
		store.txtWeekday = txtWeekday;
		store.codLanguage = codLanguage;
		return store;
	}
	
	
	
	public EmpCoInfo toEmpCoInfo() {
		EmpCoInfo empCoInfo = new EmpCoInfo();
		empCoInfo.codOwner = codOwner;
		empCoInfo.codStore = codStore;
		empCoInfo.codEmployee = codEmployee;
		empCoInfo.codWeekday = codWeekday;
		empCoInfo.txtWeekday = txtWeekday;
		empCoInfo.beginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		empCoInfo.endTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
		empCoInfo.codTimezone = codTimezone;
		empCoInfo.codLanguage = codLanguage;
		empCoInfo.recordMode = recordMode;
		
		return empCoInfo;
	}
	
	
	
	public StoreWTimeInfo toStoreWTimeInfo() {
		StoreWTimeInfo storeWTime = new StoreWTimeInfo();
		storeWTime.codOwner = codOwner;
		storeWTime.codStore = codStore;
		storeWTime.codWeekday = codWeekday;
		storeWTime.txtWeekday = txtWeekday;
		storeWTime.codTimezone = codTimezone;
		storeWTime.codLanguage = codLanguage;		
		
		if (beginTime != null) 
			storeWTime.beginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
			
		if (endTime != null) 
			storeWTime.endTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
		
		return storeWTime;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		EmpWTimeInfo deepCopy = (EmpWTimeInfo) super.clone();  		
		
		LocalTime cloneBeginTime = null;		
		if (beginTime != null) 
			cloneBeginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		
		LocalTime cloneEndTime = null;		
		if (endTime != null) 
			cloneEndTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
				
		
		deepCopy.beginTime = cloneBeginTime;
		deepCopy.endTime = cloneEndTime;
				
		return deepCopy;	
	}  
}