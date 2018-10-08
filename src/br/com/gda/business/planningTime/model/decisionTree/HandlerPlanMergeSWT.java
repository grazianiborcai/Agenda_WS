package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanMerger;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStoreWTimeSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanMergeSWT extends ActionLazyTemplate<PlanInfo, StoreWTimeInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public HandlerPlanMergeSWT(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreWTimeInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;
		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		return StoreWTimeInfo.copyFrom(collectedInfo);
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected ActionStd<StoreWTimeInfo> getInstanceOfActionHook(DeciTreeOption<StoreWTimeInfo> option) {
		return new RootStoreWTimeSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<StoreWTimeInfo> result) {
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
