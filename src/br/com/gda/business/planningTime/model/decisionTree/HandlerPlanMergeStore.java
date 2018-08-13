package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanMerger;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanMergeStore extends DeciActionHandlerTemplate<PlanInfo, StoreInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public HandlerPlanMergeStore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;
		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		return StoreInfo.copyFrom(collectedInfo);
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected DeciAction<StoreInfo> getInstanceOfActionHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<StoreInfo> result) {
		DeciResultHelper<PlanInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new PlanMerger().write(originalInfos, result.getResultset());
		
		} else {		
			List<PlanInfo> dummy = new ArrayList<>();
			dummy.add(new PlanInfo());		
			resultHelper.resultset = dummy;
		}
		
		return resultHelper;
	}
}
