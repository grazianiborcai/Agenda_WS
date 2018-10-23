package br.com.gda.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.model.action.ActionVisitorEnforce;

final class VisitorPlanEnforceWeekday implements ActionVisitorEnforce<PlanInfo> {
	
	@Override public List<PlanInfo> executeTransformation(List<PlanInfo> recordInfos) {
		List<PlanInfo> resultRecords = new ArrayList<>();		
		
		for (PlanInfo eachRecord : recordInfos) {
			resultRecords.add(enforce(eachRecord));
		}
		
		return resultRecords;
	}	
	
	
	
	private PlanInfo enforce(PlanInfo recordInfo) {
		PlanInfo enforcedInfo = makeClone(recordInfo);
		
		for (PlanDataInfo eachData: enforcedInfo.datas) {
			eachData.codWeekday = eachData.date.getDayOfWeek().getValue();
		}
		
		return enforcedInfo;
	}
	
	
	
	private PlanInfo makeClone(PlanInfo recordInfo) {
		try {
			return (PlanInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
