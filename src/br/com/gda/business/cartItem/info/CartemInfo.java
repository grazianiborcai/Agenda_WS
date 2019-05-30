package br.com.gda.business.cartItem.info;

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

public final class CartemInfo extends InfoRecord implements Cloneable, Comparable<CartemInfo> {
	public long codOwner;	
	public long codCustomer;
	public long codUser;
	public boolean isDeleted;
	public long codStore;
	public long codEmployee;
	public String nameEmployee;
	public long codMat;
	public double price;
	public int quantity;
	public double totitem;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codLanguage;
	public LocalDateTime createdOn;
	public String username;
	public StolisInfo stolisInfo;
	public EmplisInfo emplisInfo;
	public MatInfo matInfo;
	
	
	
	public CartemInfo() {
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		isDeleted = DefaultValue.boole();
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		quantity = DefaultValue.number();
		totitem = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codLanguage = DefaultValue.language();	
		stolisInfo = DefaultValue.object();
		emplisInfo = DefaultValue.object();
		matInfo = DefaultValue.object();
	}
	
	
	
	public static CartemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartemInfo.class);
	}
	
	
	
	public static List<CartemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CartemInfo deepCopy = (CartemInfo) super.clone();
		
		if (date != null)
			deepCopy.date = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
		
		if (beginTime != null)
			deepCopy.beginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute());
		
		if (endTime != null)
			deepCopy.endTime = LocalTime.of(endTime.getHour(), endTime.getMinute());
		
		if (createdOn != null)
			deepCopy.createdOn = createdOn;
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CartemInfo))
			return false;
		
		
		CartemInfo obj = (CartemInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codCustomer == obj.codCustomer 		&&
				codUser     == obj.codUser			&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(CartemInfo arg0) {
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
