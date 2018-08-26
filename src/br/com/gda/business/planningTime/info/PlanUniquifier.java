package br.com.gda.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoUniquifier;

final class PlanUniquifier implements InfoUniquifier<PlanInfo> {
	private List<StoreInfo> allStores;
	private List<MatInfo> allMaterials;
	private List<EmpInfo> allEmployees;
	private List<WeekdayInfo> allWeekdays;
	private List<PlanDataInfo> allDatas;	
	private List<PlanInfo> results; 
	
	
	@Override public List<PlanInfo> uniquify(List<PlanInfo> infoRecords) {
		init();
		collect(infoRecords);
		removeDuplicate();
		makeResult();
		
		return results;
	}
	
	
	
	private void init() {
		allStores = new ArrayList<>();
		allMaterials = new ArrayList<>();
		allEmployees = new ArrayList<>();
		allWeekdays = new ArrayList<>();
		allDatas = new ArrayList<>();
		results = new ArrayList<>();
	}
	
	
	
	private void collect(List<PlanInfo> recordInfos) {		
		for (PlanInfo eachRecord : recordInfos) {
			allStores.addAll(eachRecord.stores);
			allMaterials.addAll(eachRecord.materials);
			allEmployees.addAll(eachRecord.employees);
			allWeekdays.addAll(eachRecord.weekdays);
			allDatas.addAll(eachRecord.datas);
		}		
	}
	
	
	
	private void removeDuplicate() {
		allStores = allStores.stream().distinct().collect(Collectors.toList());		
		allMaterials = allMaterials.stream().distinct().collect(Collectors.toList());
		allEmployees = allEmployees.stream().distinct().collect(Collectors.toList());
		allWeekdays = allWeekdays.stream().distinct().collect(Collectors.toList());
		allDatas = allDatas.stream().distinct().collect(Collectors.toList());
	}
	
	
	
	private void makeResult() {
		PlanInfo tempResult = new PlanInfo();
		tempResult.stores = allStores;
		tempResult.materials = allMaterials;
		tempResult.employees = allEmployees;
		tempResult.weekdays = allWeekdays;
		tempResult.datas = allDatas;
		
		results.add(tempResult);
	}
}
