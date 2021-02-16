package br.com.mind5.business.planningTime.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class PlanimeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String username;
	public List<LocalDate> dates;
	public List<StolisInfo> stolises;
	public List<MatlisInfo> matlises;
	public List<EmplresInfo> emplreses;
	public List<WeekdayInfo> weekdays;
	public List<DaypartInfo> dayparts;
	public List<MoonaseInfo> moonases;
	public List<PlanataInfo> planatas;	
	
	
	public PlanimeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		dates = DefaultValue.list();
		stolises = DefaultValue.list();
		matlises = DefaultValue.list();
		emplreses = DefaultValue.list();
		weekdays = DefaultValue.list();
		dayparts = DefaultValue.list();
		moonases = DefaultValue.list();
		planatas = DefaultValue.list();
	}
	
	
	
	public static PlanimeInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanimeInfo.class);
	}
	
	
	
	public static List<PlanimeInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanimeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException { 
		PlanimeInfo deepCopy = (PlanimeInfo) super.clone();
		
		deepCopy.dates = cloneDates(deepCopy.dates);
		deepCopy.stolises = CloneUtil.cloneRecords(deepCopy.stolises, this.getClass());
		deepCopy.matlises = CloneUtil.cloneRecords(deepCopy.matlises, this.getClass());
		deepCopy.emplreses = CloneUtil.cloneRecords(deepCopy.emplreses, this.getClass());
		deepCopy.weekdays = CloneUtil.cloneRecords(deepCopy.weekdays, this.getClass());
		deepCopy.dayparts = CloneUtil.cloneRecords(deepCopy.dayparts, this.getClass());
		deepCopy.moonases = CloneUtil.cloneRecords(deepCopy.moonases, this.getClass());
		deepCopy.planatas = CloneUtil.cloneRecords(deepCopy.planatas, this.getClass());		
		
		return deepCopy;
	}
	
	
	
	private List<LocalDate> cloneDates(List<LocalDate> dates) {
		if (dates == null)
			return dates;	
		
		return new ArrayList<>(dates);
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));

		if (stolises != null)
			result = result * 31 + stolises.hashCode();
		
		if (matlises != null)
			result = result * 31 + matlises.hashCode();
		
		if (emplreses != null)
			result = result * 31 + emplreses.hashCode();
		
		if (weekdays != null)
			result = result * 31 + weekdays.hashCode();
		
		if (planatas != null)
			result = result * 31 + planatas.hashCode();
		
		if (dates != null)
			result = result * 31 + dates.hashCode();
		
		if (dayparts != null)
			result = result * 31 + dayparts.hashCode();
		
		if (moonases != null)
			result = result * 31 + moonases.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanimeInfo))
			return false;
		
		
		PlanimeInfo obj = (PlanimeInfo) o;
		
		return (codOwner == obj.codOwner					&&
				super.isListEqual(stolises , obj.stolises)	&&
				super.isListEqual(matlises , obj.matlises) 	&&
				super.isListEqual(emplreses , obj.emplreses) 	&&
				super.isListEqual(weekdays , obj.weekdays) 	&&				
				super.isListDateEqual(dates , obj.dates) 	&&
				super.isListEqual(dayparts , obj.dayparts) 	&&
				super.isListEqual(moonases , obj.moonases) 	&&				
				super.isListEqual(planatas , obj.planatas));
	}
}
