package br.com.gda.business.planningTime_.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.RootEmplevateSelect;
import br.com.gda.business.planningTime_.info.PlanDataInfo;
import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.info.PlanPruner;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyPlanPruneELD extends ActionLazyTemplate<PlanInfo, EmplevateInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public LazyPlanPruneELD(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplevateInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		
		List<EmplevateInfo> empLdates = new ArrayList<>();
		empLdates.addAll(EmplevateInfo.copyFrom(collectedInfo));
		
		return empLdates;
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> getInstanceOfActionHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<EmplevateInfo> result) {
		DeciResultHelper<PlanInfo> resultHelper = new DeciResultHelper<>();		
		
		if (result.hasResultset()) {
			resultHelper.copyWithoutResultset(result);
			resultHelper.resultset = new PlanPruner().merge(originalInfos, result.getResultset());
		
		} else {		
			resultHelper.isSuccess = true;
			resultHelper.hasResultset = true;
			resultHelper.resultset = originalInfos;
		}
		
		return resultHelper;
	}
}
