package br.com.mind5.business.planningTime.info;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoUniquifier;

final class PlanimeUniquifier implements InfoUniquifier<PlanimeInfo> {
	private List<StolisInfo> allStores;
	private List<LocalDate> allDates;
	private List<MatlisInfo> allMaterials;
	private List<EmplisInfo> allEmployees;
	private List<WeekdayInfo> allWeekdays;
	private List<PlanataInfo> allPlanatas;	
	private List<PlanimeInfo> results; 
	
	
	@Override public List<PlanimeInfo> uniquify(List<PlanimeInfo> infoRecords) {
		init();
		collect(infoRecords);
		removeDuplicate();
		makeResult();
		
		return results;
	}
	
	
	
	private void init() {
		allStores = DefaultValue.list();
		allDates = DefaultValue.list();
		allMaterials = DefaultValue.list();
		allEmployees = DefaultValue.list();
		allWeekdays = DefaultValue.list();
		allPlanatas = DefaultValue.list();
		results = DefaultValue.list();
	}
	
	
	
	private void collect(List<PlanimeInfo> recordInfos) {		
		for (PlanimeInfo eachRecord : recordInfos) {
			allStores.addAll(eachRecord.stores);
			allDates.addAll(eachRecord.dates);
			allMaterials.addAll(eachRecord.materials);
			allEmployees.addAll(eachRecord.employees);
			allWeekdays.addAll(eachRecord.weekdays);
			allPlanatas.addAll(eachRecord.planatas);
		}		
	}
	
	
	
	private void removeDuplicate() {
		allStores = allStores.stream().distinct().collect(Collectors.toList());		
		allDates = allDates.stream().distinct().collect(Collectors.toList());	
		allMaterials = allMaterials.stream().distinct().collect(Collectors.toList());
		allEmployees = allEmployees.stream().distinct().collect(Collectors.toList());
		allWeekdays = allWeekdays.stream().distinct().collect(Collectors.toList());
		allPlanatas = allPlanatas.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void makeResult() {
		PlanimeInfo tempResult = new PlanimeInfo();
		tempResult.stores = allStores;
		tempResult.dates = allDates;
		tempResult.materials = allMaterials;
		tempResult.employees = allEmployees;
		tempResult.weekdays = allWeekdays;
		tempResult.planatas = allPlanatas;
		
		results.add(tempResult);
	}
}
