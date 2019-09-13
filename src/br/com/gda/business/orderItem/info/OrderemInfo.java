package br.com.gda.business.orderItem.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class OrderemInfo extends InfoRecord implements Cloneable, Comparable<OrderemInfo> {
	public long codOwner;
	public long codOrder;
	public int codOrderItem;
	public long codSnapshot;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public double price;
	public int quantity;
	public double totitem;
	public String codCurr;
	public String txtCurr;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public StolisInfo stolisData;
	public EmplisInfo emplisData;
	public MatInfo matData;
	
	
	
	public OrderemInfo() {
		super(OrderemInfo.class);
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();
		codOrderItem = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		quantity = DefaultValue.number();
		totitem = DefaultValue.number();
		codWeekday = DefaultValue.number();
		lastChangedBy = DefaultValue.number();	
		stolisData = DefaultValue.object();
		emplisData = DefaultValue.object();
		matData = DefaultValue.object();
	}
	
	
	
	public static OrderemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrderemInfo.class);
	}
	
	
	
	public static List<OrderemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrderemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrderemInfo deepCopy = (OrderemInfo) super.clone();
		
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
		
		result = result * 31 + (int) (codOwner    	^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codOrder 	  	^ (codOrder 	 	>>> 32));
		result = result * 31 + (int) (codOrderItem 	^ (codOrderItem 	>>> 32));
		result = result * 31 + (int) (codStore 	  	^ (codStore 	 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 		>>> 32));
		result = result * 31 + (int) (codMat 	  	^ (codMat 	 		>>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrderemInfo))
			return false;
		
		
		OrderemInfo obj = (OrderemInfo) o;		
		return (codOwner    	== obj.codOwner    		&& 
				codOrder    	== obj.codOrder			&&
				codOrderItem	== obj.codOrderItem		&&
				codStore    	== obj.codStore			&&
				codEmployee 	== obj.codEmployee		&&
				codMat    		== obj.codMat			&&
				super.isDateEqual(date, obj.date)		&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(OrderemInfo arg0) {
		if (arg0 == null) {
			super.logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		
		if (codOrderItem< arg0.codOrderItem)
			return -1;
		
		if (codOrderItem > arg0.codOrderItem)
			return 1;
		
		if (equals(arg0))
			return 0;
		
		
		super.logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);
	}
}
