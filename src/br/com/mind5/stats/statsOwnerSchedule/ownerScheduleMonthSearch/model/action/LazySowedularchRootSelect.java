package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree.RootSowedularchSelect;

public final class LazySowedularchRootSelect extends ActionLazyTemplate<SowedularchhInfo, SowedularchhInfo> {

	public LazySowedularchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowedularchhInfo> translateRecordInfosHook(List<SowedularchhInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowedularchhInfo> getInstanceOfActionHook(DeciTreeOption<SowedularchhInfo> option) {
		return new RootSowedularchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowedularchhInfo> translateResultHook(DeciResult<SowedularchhInfo> result) {
		return result;
	}
}
