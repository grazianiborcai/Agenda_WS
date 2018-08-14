package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanPruner;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.RootStoreLDateSelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanPruneSLD extends DeciActionHandlerTemplate<PlanInfo, StoreLDateInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public HandlerPlanPruneSLD(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreLDateInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		
		List<StoreLDateInfo> storeLdates = new ArrayList<>();
		storeLdates.addAll(StoreLDateInfo.copyFrom(collectedInfo));
		
		return storeLdates;
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected DeciAction<StoreLDateInfo> getInstanceOfActionHook(DeciTreeOption<StoreLDateInfo> option) {
		return new RootStoreLDateSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<StoreLDateInfo> result) {
		DeciResultHelper<PlanInfo> resultHelper = new DeciResultHelper<>();		
		
		if (result.hasResultset()) {
			resultHelper.copyWithoutResultset(result);
			resultHelper.resultset = new PlanPruner().write(originalInfos, result.getResultset());
		
		} else {		
			resultHelper.finishedWithSuccess = true;
			resultHelper.hasResultset = true;
			resultHelper.resultset = originalInfos;
		}
		
		return resultHelper;
	}
}
