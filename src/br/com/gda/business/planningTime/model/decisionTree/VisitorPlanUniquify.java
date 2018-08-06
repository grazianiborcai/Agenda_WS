package br.com.gda.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorPlanUniquify implements DeciActionTransVisitor<PlanInfo> {
	private List<StoreInfo> allStores;
	private List<MatInfo> allMaterials;
	private List<EmpInfo> allEmployees;
	private List<WeekdayInfo> allWeekdays;
	private List<PlanDataInfo> allDatas;	
	private List<PlanInfo> result; 
	
	
	public VisitorPlanUniquify() {
		allStores = new ArrayList<>();
		allMaterials = new ArrayList<>();
		allEmployees = new ArrayList<>();
		allWeekdays = new ArrayList<>();
		allDatas = new ArrayList<>();
		result = new ArrayList<>();
	}
	
	
	
	@Override public List<PlanInfo> executeTransformation(List<PlanInfo> recordInfos) {
		collect(recordInfos);
		uniquify();
		makeResult();
		
		return result;
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
	
	
	
	private void uniquify() {
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
		
		result.add(tempResult);
	}
}
