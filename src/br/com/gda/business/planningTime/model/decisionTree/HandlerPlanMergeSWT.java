package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanMerger;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanMergeSWT extends ActionLazyTemplate<PlanInfo, StowotmInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public HandlerPlanMergeSWT(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StowotmInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;
		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		return StowotmInfo.copyFrom(collectedInfo);
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> getInstanceOfActionHook(DeciTreeOption<StowotmInfo> option) {
		return new RootStowotmSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<StowotmInfo> result) {
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
