package br.com.gda.business.scheduleLineSnapshot.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class SchedinapInfo extends InfoRecord implements Cloneable, Comparable<SchedinapInfo> {
	public long codOwner;
	public long codSnapshot;
	public long codSchedule;	
	public String codScheduleStatus;
	public long codOrder;
	public int codOrderItem;
	public long codStore;
	public long codStoreSnapshot;
	public long codEmployee;
	public long codEmployeeSnapshot;
	public long codMat;
	public long codMatSnapshot;
	public LocalDate date;
	public int codWeekday;
	public int day;
	public int weekMonth;
	public int weekYear;
	public int month;
	public int quarter;
	public int year;	
	public LocalTime beginTime;
	public LocalTime endTime;
	public long codUser;
	public long codUserSnapshot;
	public long codCustomer;
	public long codCustomerSnapshot;
	public MatsnapInfo matData;
	public String codLanguage;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;	
	
	
	public SchedinapInfo() {
		super(SchedinapInfo.class);
		
		codOwner = DefaultValue.number();	
		codSchedule = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codOrder = DefaultValue.number();
		codOrderItem = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		codMatSnapshot = DefaultValue.number();
		codWeekday = DefaultValue.number();
		day = DefaultValue.number();
		weekMonth = DefaultValue.number();
		weekYear = DefaultValue.number();
		month = DefaultValue.number();
		quarter = DefaultValue.number();
		year = DefaultValue.number();	
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		createdBy = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		codLanguage = DefaultValue.language();	
		recordMode = DefaultValue.recordMode();
		matData = DefaultValue.object();
	}
	
	
	
	public static SchedinapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedinapInfo.class);
	}
	
	
	
	public static List<SchedinapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedinapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedinapInfo deepCopy = (SchedinapInfo) super.clone();
		
		deepCopy.date = date;
		deepCopy.beginTime = beginTime;
		deepCopy.endTime = endTime;
		deepCopy.lastChanged = lastChanged;
		deepCopy.matData = cloneMat(matData);
		
		return deepCopy;
	}	
	
	
	
	private MatsnapInfo cloneMat(MatsnapInfo recordInfo) throws CloneNotSupportedException {
		MatsnapInfo result = null;
		
		if (recordInfo != null)
			result = (MatsnapInfo) recordInfo.clone();
		
		return result;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codSchedule ^ (codSchedule >>> 32));
		result = result * 31 + (int) (codOrder 	  ^ (codOrder 	 >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchedinapInfo))
			return false;
		
		
		SchedinapInfo obj = (SchedinapInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codSnapshot == obj.codSnapshot    	&& 
				codSchedule == obj.codSchedule		&&
				codOrder    == obj.codOrder			&&
				codStore    == obj.codStore			&&
				codEmployee == obj.codEmployee		&&
				codMat    	== obj.codMat			&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(SchedinapInfo arg0) {
		if (arg0 == null) {
			super.logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		/*
		if (itemNumber < arg0.itemNumber)
			return -1;
		
		if (itemNumber > arg0.itemNumber)
			return 1;
		
		if (equals(arg0))*/
			return 0;
		
		/*
		super.logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);*/
	}
}
