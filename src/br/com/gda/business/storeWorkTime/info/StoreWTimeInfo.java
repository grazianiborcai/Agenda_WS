package br.com.gda.business.storeWorkTime.info;

import java.time.LocalTime;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class StoreWTimeInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codLanguage;
	public String recordMode;
	
	
	public StoreWTimeInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
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
	
	
	
	public WeekdayInfo toWeekdayInfo() {
		WeekdayInfo store = new WeekdayInfo();
		store.codWeekday = codWeekday;
		store.txtWeekday = txtWeekday;
		store.codLanguage = codLanguage;
		return store;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		StoreWTimeInfo deepCopy = (StoreWTimeInfo) super.clone();  		
		
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
