package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.planningTime_.info.PlanDataInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class StolevateInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String codTimezone;
	public String description;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StolevateInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codLanguage = DefaultValue.language();
		lastChangedBy = DefaultValue.number();
		recordMode = RecordMode.RECORD_OK;
	}
	
	
	//TODO: Mover para Copier
	public static StolevateInfo copyFrom(Object sourceObj) {
		if (isPlanData(sourceObj))
			return copyFromPlanData(sourceObj);
		
		if (isCart(sourceObj))
			return copyFromCart(sourceObj);
		
		return copyFrom(sourceObj, StolevateInfo.class);
	}
	
	
	
	public static List<StolevateInfo> copyFrom(List<?> sourceObjs) {
		if (isPlanData(sourceObjs))
			return copyFromPlanData(sourceObjs);
		
		if (isCart(sourceObjs))
			return copyFromCart(sourceObjs);
			
		return copyFrom(sourceObjs, StolevateInfo.class);
	}
	
	
	
	private static boolean isPlanData(List<?> sourceObjs) {
		if (sourceObjs == null || sourceObjs.isEmpty())
			return false;
		
		return isPlanData(sourceObjs.get(0));
	}
	
	
	
	private static boolean isPlanData(Object sourceObj) {
		if (sourceObj == null)
			return false;
		
		if (sourceObj instanceof PlanDataInfo)
			return true;
		
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static List<StolevateInfo> copyFromPlanData(List<?> sourceObjs) {
		return new StolevateCopyPlan_().makeCopy( (List<PlanDataInfo>)sourceObjs);
	}
	
	
	
	private static StolevateInfo copyFromPlanData(Object sourceObj) {
		return new StolevateCopyPlan_().makeCopy( (PlanDataInfo)sourceObj);
	}
	
	
	
	private static boolean isCart(List<?> sourceObjs) {
		if (sourceObjs == null || sourceObjs.isEmpty())
			return false;
		
		return isCart(sourceObjs.get(0));
	}
	
	
	
	private static boolean isCart(Object sourceObj) {
		if (sourceObj == null)
			return false;
		
		if (sourceObj instanceof CartInfo)
			return true;
		
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private static List<StolevateInfo> copyFromCart(List<?> sourceObjs) {
		return new StolevateCopyCart().makeCopy( (List<CartInfo>)sourceObjs);
	}
	
	
	
	private static StolevateInfo copyFromCart(Object sourceObj) {
		return new StolevateCopyCart().makeCopy( (CartInfo)sourceObj);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		StolevateInfo deepCopy = (StolevateInfo) super.clone();  		
		
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
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
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
		
		
		if (!(o instanceof StolevateInfo))
			return false;
		
		
		StolevateInfo obj = (StolevateInfo) o;
				
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				isDateEqual(dateValidFrom, obj.dateValidFrom) &&
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}
}
