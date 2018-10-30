package br.com.gda.business.planningTime.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanPruner;
import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.business.reserve.model.decisionTree.RootReserveSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerPlanPruneReserve extends ActionLazyTemplate<PlanInfo, ReserveInfo> {
	private List<PlanInfo> originalInfos;
	
	
	public HandlerPlanPruneReserve(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<ReserveInfo> translateRecordInfosHook(List<PlanInfo> recordInfos) {
		originalInfos = recordInfos;		
		List<PlanDataInfo> collectedInfo = collectDataInfo(recordInfos);
		
		List<ReserveInfo> reserves = new ArrayList<>();
		reserves.addAll(ReserveInfo.copyFrom(collectedInfo));
		
		return reserves;
	}
	
	
	
	private List<PlanDataInfo> collectDataInfo(List<PlanInfo> recordInfos) {
		List<PlanDataInfo> dataInfos = new ArrayList<>();
		
		for(PlanInfo eachrecord : recordInfos) {
			dataInfos.addAll(eachrecord.datas);
		}
		
		return dataInfos;
	}
	
	
	
	@Override protected ActionStd<ReserveInfo> getInstanceOfActionHook(DeciTreeOption<ReserveInfo> option) {
		return new RootReserveSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PlanInfo> translateResultHook(DeciResult<ReserveInfo> result) {
		DeciResultHelper<PlanInfo> resultHelper = new DeciResultHelper<>();		
		
		if (result.hasResultset()) {
			resultHelper.copyWithoutResultset(result);
			resultHelper.resultset = new PlanPruner().prune(originalInfos, result.getResultset());	
			
		} else {		
			resultHelper.isSuccess = true;
			resultHelper.hasResultset = true;
			resultHelper.resultset = originalInfos;
		}
		
		
		if (resultHelper.resultset.isEmpty())
			return responseDataNotFound();
		
		return resultHelper;
	}
	
	
	
	private DeciResult<PlanInfo> responseDataNotFound() {
		//TODO: DATA_NOT_FOUND deverá ficar em uma classe já pronta. Evitar repetição no código
		DeciResultHelper<PlanInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.hasResultset = false;		
		resultHelper.failMessage = SystemMessage.DATA_NOT_FOUND;
		resultHelper.failCode = SystemCode.DATA_NOT_FOUND;
		resultHelper.isSuccess = false;
		
		return resultHelper;
	}
}
