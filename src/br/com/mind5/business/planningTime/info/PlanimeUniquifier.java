package br.com.mind5.business.planningTime.info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;

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
			result = uniquifyPlanata(result);
			
			results.add(result);
		}
		
		return results;
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
		if (result.emplises == null)
			return result;
		
		List<EmplisInfo> allEmployees = new ArrayList<>(result.emplises);
		allEmployees = allEmployees.stream().distinct().collect(Collectors.toList());			
		
		result.emplises = allEmployees;
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
