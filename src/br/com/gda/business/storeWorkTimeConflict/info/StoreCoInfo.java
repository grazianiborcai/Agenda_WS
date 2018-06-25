package br.com.gda.business.storeWorkTimeConflict.info;

import java.time.LocalTime;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class StoreCoInfo implements Cloneable {
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
	
	
	public StoreCoInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codWeekday = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public StoreWTimeInfo toStoreWTimeInfo() {
		StoreWTimeInfo storeWTimeInfo = new StoreWTimeInfo();
		storeWTimeInfo.codOwner = codOwner;
		storeWTimeInfo.codStore = codStore;
		storeWTimeInfo.codWeekday = codWeekday;
		storeWTimeInfo.txtWeekday = txtWeekday;
		storeWTimeInfo.beginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute());
		storeWTimeInfo.endTime = LocalTime.of(endTime.getHour(), endTime.getMinute());
		storeWTimeInfo.codTimezone = codTimezone;
		storeWTimeInfo.codLanguage = codLanguage; 
		storeWTimeInfo.recordMode = recordMode;
		
		return storeWTimeInfo;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		StoreCoInfo deepCopy = (StoreCoInfo) super.clone();  		
		
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
