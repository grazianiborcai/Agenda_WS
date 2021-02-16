package br.com.mind5.business.planningTime.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

final class PlanimeUniquifier implements InfoUniquifier<PlanimeInfo> {	
	
	@Override public List<PlanimeInfo> uniquify(List<PlanimeInfo> infoRecords) {
		List<PlanimeInfo> results = new ArrayList<>();
		
		for (PlanimeInfo eachRecord : infoRecords) {
			PlanimeInfo result = makeClone(eachRecord);
			
			result = uniquifyStore(result);
			result = uniquifyDate(result);
			result = uniquifyMaterial(result);
			result = uniquifyEmployee(result);
			result = uniquifyWeekday(result);
			result = uniquifyDaypart(result);
			result = uniquifyMoonase(result);
			result = uniquifyPlanata(result);
			
			results.add(result);
		}
		
		return results.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private PlanimeInfo uniquifyStore(PlanimeInfo result) {
		if (result.stolises == null)
			return result;
		
		List<StolisInfo> allStores = new ArrayList<>(result.stolises);
		allStores = allStores.stream().distinct().collect(Collectors.toList());			
		
		result.stolises = allStores;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyDate(PlanimeInfo result) {
		if (result.dates == null)
			return result;
		
		List<LocalDate> allDates = new ArrayList<>(result.dates);
		allDates = allDates.stream().distinct().collect(Collectors.toList());			
		
		result.dates = allDates;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyMaterial(PlanimeInfo result) {
		if (result.matlises == null)
			return result;
		
		List<MatlisInfo> allMaterials = new ArrayList<>(result.matlises);
		allMaterials = allMaterials.stream().distinct().collect(Collectors.toList());			
		
		result.matlises = allMaterials;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyEmployee(PlanimeInfo result) {
		if (result.emplreses == null)
			return result;
		
		List<EmplresInfo> allEmployees = new ArrayList<>(result.emplreses);
		allEmployees = allEmployees.stream().distinct().collect(Collectors.toList());			
		
		result.emplreses = allEmployees;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyWeekday(PlanimeInfo result) {
		if (result.weekdays == null)
			return result;
		
		List<WeekdayInfo> allWeekdays = new ArrayList<>(result.weekdays);
		allWeekdays = allWeekdays.stream().distinct().collect(Collectors.toList());			
		
		result.weekdays = allWeekdays;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyMoonase(PlanimeInfo result) {
		if (result.moonases == null)
			return result;
		
		List<MoonaseInfo> allMoonases = new ArrayList<>(result.moonases);
		allMoonases = allMoonases.stream().distinct().collect(Collectors.toList());			
		
		result.moonases = allMoonases;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyDaypart(PlanimeInfo result) {
		if (result.dayparts == null)
			return result;
		
		List<DaypartInfo> allDayparts = new ArrayList<>(result.dayparts);
		allDayparts = allDayparts.stream().distinct().collect(Collectors.toList());			
		
		result.dayparts = allDayparts;
		return result;
	}
	
	
	
	private PlanimeInfo uniquifyPlanata(PlanimeInfo result) {
		if (result.planatas == null)
			return result;
		
		List<PlanataInfo> allplanatas = new ArrayList<>(result.planatas);
		allplanatas = allplanatas.stream().distinct().collect(Collectors.toList());			
		
		result.planatas = allplanatas;
		return result;
	}
	
	
	
	private PlanimeInfo makeClone(PlanimeInfo infoRecord) {
		try {
			return (PlanimeInfo) infoRecord.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
