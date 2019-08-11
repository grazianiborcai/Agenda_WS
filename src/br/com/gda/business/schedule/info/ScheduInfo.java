package br.com.gda.business.schedule.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class ScheduInfo extends InfoRecord implements Cloneable, Comparable<ScheduInfo> {
	public long codOwner;
	public long codOrder;
	public long codStore;
	public long codStoreSnapshot;
	public long codEmployee;
	public long codEmployeeSnapshot;
	public long codMat;
	public long codMatSnapshot;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public long codUser;
	public long codUserSnapshot;
	public long codCustomer;
	public long codCustomerSnapshot;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public StolisInfo stolisData;
	public EmplisInfo emplisData;
	public MatInfo matData;
	public String recordMode;
	
	
	
	public ScheduInfo() {
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();
		codStore = DefaultValue.number();
		codStoreSnapshot = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codEmployeeSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		codMatSnapshot = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codUser = DefaultValue.number();
		codUserSnapshot = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codCustomerSnapshot = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		codLanguage = DefaultValue.language();	
		stolisData = DefaultValue.object();
		emplisData = DefaultValue.object();
		matData = DefaultValue.object();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static ScheduInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ScheduInfo.class);
	}
	
	
	
	public static List<ScheduInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ScheduInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		ScheduInfo deepCopy = (ScheduInfo) super.clone();
		
		deepCopy.date = date;
		deepCopy.beginTime = beginTime;
		deepCopy.endTime = endTime;
		deepCopy.lastChanged = lastChanged;
		deepCopy.stolisData = cloneStolis(stolisData);
		deepCopy.emplisData = cloneEmplis(emplisData);
		deepCopy.matData = cloneMat(matData);
		
		return deepCopy;
	}
	
	
	
	private MatInfo cloneMat(MatInfo recordInfo) throws CloneNotSupportedException {
		MatInfo result = null;
		
		if (recordInfo != null)
			result = (MatInfo) recordInfo.clone();
		
		return result;
	}
	
	
	
	private StolisInfo cloneStolis(StolisInfo recordInfo) throws CloneNotSupportedException {
		StolisInfo result = null;
		
		if (recordInfo != null)
			result = (StolisInfo) recordInfo.clone();
		
		return result;
	}
	
	
	
	private EmplisInfo cloneEmplis(EmplisInfo recordInfo) throws CloneNotSupportedException {
		EmplisInfo result = null;
		
		if (recordInfo != null)
			result = (EmplisInfo) recordInfo.clone();
		
		return result;
	}		
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
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
		
		
		if (!(o instanceof ScheduInfo))
			return false;
		
		
		ScheduInfo obj = (ScheduInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codOrder    == obj.codOrder			&&
				codStore    == obj.codStore			&&
				codEmployee == obj.codEmployee		&&
				codMat    	== obj.codMat			&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(ScheduInfo arg0) {
		if (arg0 == null) {
			logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
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
		logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);*/
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
