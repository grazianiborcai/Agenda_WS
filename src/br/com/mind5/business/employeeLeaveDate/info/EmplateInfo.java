package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmplateInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String codTimezone;
	public String txtTimezone;
	public String description;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmplateInfo() {
		super(EmplateInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
	}
	
	
	//TODO: mover para Copier
	public static EmplateInfo copyFrom(Object sourceObj) {
		if (isCart(sourceObj))
			return copyFromCart(sourceObj);
		
		return copyFrom(sourceObj, EmplateInfo.class);
	}
	
	
	
	public static List<EmplateInfo> copyFrom(List<?> sourceObjs) {
		if (isCart(sourceObjs))
			return copyFromCart(sourceObjs);
		
		return copyFrom(sourceObjs, EmplateInfo.class);
	}
	
	
	
	private static boolean isCart(List<?> sourceObjs) {
		if (sourceObjs == null || sourceObjs.isEmpty())
			return false;
		
		return isCart(sourceObjs.get(0));
	}
	
	
	
	private static boolean isCart(Object sourceObj) {
		if (sourceObj == null)
			return false;
		
		if (sourceObj instanceof CartemInfo)
			return true;
		
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static List<EmplateInfo> copyFromCart(List<?> sourceObjs) {
		return new EmplateCopyCart().makeCopy( (List<CartemInfo>)sourceObjs);
	}
	
	
	
	private static EmplateInfo copyFromCart(Object sourceObj) {
		return new EmplateCopyCart().makeCopy( (CartemInfo)sourceObj);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmplateInfo deepCopy = (EmplateInfo) super.clone();  		
		
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
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		if (dateValidFrom != null) {			
			int numDate = Integer.valueOf(dateValidFrom.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + (int) numDate;
		}
		
		if (timeValidFrom != null) {			
			int numTime = Integer.valueOf(timeValidFrom.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + (int) numTime;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmplateInfo))
			return false;
		
		
		EmplateInfo obj = (EmplateInfo) o;
		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				isDateEqual(dateValidFrom, obj.dateValidFrom) &&
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}
}
