package br.com.gda.business.employeeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.timeRange.info.TimeRangeInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class EmpLDateInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String codTimezone;
	public String description;
	public String codLanguage;
	public String recordMode;
	
	
	public EmpLDateInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public OwnerInfo toOwnerInfo() {
		OwnerInfo owner = new OwnerInfo();
		owner.codOwner = codOwner;
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
	
	
	
	public TimeRangeInfo toTimeRangeInfo() {
		TimeRangeInfo timeRange = new TimeRangeInfo();
		
		if (dateValidFrom != null)
			timeRange.dateValidFrom = LocalDate.of(dateValidFrom.getYear(), dateValidFrom.getMonth(), dateValidFrom.getDayOfMonth());
		
		if (dateValidTo != null)
			timeRange.dateValidTo = LocalDate.of(dateValidTo.getYear(), dateValidTo.getMonth(), dateValidTo.getDayOfMonth());
		
		if (timeValidFrom != null)
			timeRange.timeValidFrom = LocalTime.of(timeValidFrom.getHour(), timeValidFrom.getMinute(), timeValidFrom.getSecond());
		
		if (timeValidTo != null)
			timeRange.timeValidTo = LocalTime.of(timeValidTo.getHour(), timeValidTo.getMinute(), timeValidTo.getSecond());
		
		return timeRange;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmpLDateInfo deepCopy = (EmpLDateInfo) super.clone();  		
		
		LocalTime cloneTimeValidFrom = null;		
		if (timeValidFrom != null) 
			cloneTimeValidFrom = LocalTime.of(timeValidFrom.getHour(), timeValidFrom.getMinute(), timeValidFrom.getSecond());
		
		
		LocalTime cloneTimeValidTo = null;		
		if (timeValidTo != null) 
			cloneTimeValidTo = LocalTime.of(timeValidTo.getHour(), timeValidTo.getMinute(), timeValidTo.getSecond());
		
		
		LocalDate cloneDateValidFrom = null;	
		if (dateValidFrom != null) 
			cloneDateValidFrom = LocalDate.of(dateValidFrom.getYear(), dateValidFrom.getMonth(), dateValidFrom.getDayOfMonth());
		
		
		LocalDate cloneDateValidTo = null;	
		if (dateValidTo != null) 
			cloneDateValidTo = LocalDate.of(dateValidTo.getYear(), dateValidTo.getMonth(), dateValidTo.getDayOfMonth());
				
		
		deepCopy.timeValidFrom = cloneTimeValidFrom;
		deepCopy.timeValidTo = cloneTimeValidTo;
		deepCopy.dateValidFrom = cloneDateValidFrom;
		deepCopy.dateValidTo = cloneDateValidTo;
				
		return deepCopy;	
	}  
}
