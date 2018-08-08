package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpSelect;
import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanMerger;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanMergeEmp extends DeciActionHandlerTemplate<PlanInfo, EmpInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public HandlerPlanMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;
		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		return EmpInfo.copyFrom(collectedInfo);
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected DeciAction<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new RootEmpSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<EmpInfo> result) {
		DeciResultHelper<PlanInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new PlanMerger().merge(originalInfos, result.getResultset());
		
		} else {		
			List<PlanInfo> dummy = new ArrayList<>();
			dummy.add(new PlanInfo());		
			resultHelper.resultset = dummy;
		}
		
		return resultHelper;
	}
}
