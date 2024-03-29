package br.com.mind5.business.scheduleLine.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class SchedineInfo extends InfoRecord implements Cloneable, Comparable<SchedineInfo> {
	public long codOwner;
	public long codSchedule;
	public long codScheduleRef;
	public long codSnapshot;
	public String codScheduleStatus;
	public String codScheduleStatusOld;	//TODO: remover ?
	public String txtScheduleStatus;
	public long codOrder;
	public int codOrderItem;
	public String codOrderStatus;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public int day;
	public int weekMonth;
	public int weekYear;
	public int month;
	public int quarter;
	public int year;	
	public LocalTime beginTime;
	public LocalTime endTime;
	public long codUser;
	public long codCustomer;
	public long codPet;
	public MatlisInfo matlisData;
	public StolisInfo stolisData;
	public EmplresInfo emplresData;
	public PetlisInfo petlisData;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;	
	
	
	public SchedineInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codSchedule = DefaultValue.number();
		codScheduleRef = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codOrder = DefaultValue.number();
		codOrderItem = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codWeekday = DefaultValue.number();
		day = DefaultValue.number();
		weekMonth = DefaultValue.number();
		weekYear = DefaultValue.number();
		month = DefaultValue.number();
		quarter = DefaultValue.number();
		year = DefaultValue.number();	
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codPet = DefaultValue.number();
		createdBy = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		matlisData = DefaultValue.object();
		stolisData = DefaultValue.object();
		emplresData = DefaultValue.object();
		petlisData = DefaultValue.object();
	}
	
	
	
	public static SchedineInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchedineInfo.class);
	}
	
	
	
	public static List<SchedineInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchedineInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		SchedineInfo deepCopy = (SchedineInfo) super.clone();
		
		deepCopy.date        = date;
		deepCopy.beginTime   = beginTime;
		deepCopy.endTime     = endTime;
		deepCopy.lastChanged = lastChanged;
		deepCopy.matlisData  = CloneUtil.cloneRecord(matlisData, this.getClass());
		deepCopy.stolisData  = CloneUtil.cloneRecord(stolisData, this.getClass());
		deepCopy.emplresData = CloneUtil.cloneRecord(emplresData, this.getClass());
		deepCopy.petlisData  = CloneUtil.cloneRecord(petlisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
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
		
		
		if (!(o instanceof SchedineInfo))
			return false;
		
		
		SchedineInfo obj = (SchedineInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codSchedule == obj.codSchedule		&&
				codOrder    == obj.codOrder			&&
				codStore    == obj.codStore			&&
				codEmployee == obj.codEmployee		&&
				codMat    	== obj.codMat			&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(SchedineInfo arg0) {
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
