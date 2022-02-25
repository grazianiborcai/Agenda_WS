package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree.RootSowedularchSelect;

public final class LazySowedularchRootSelect extends ActionLazyTemplate<SowedularchInfo, SowedularchInfo> {

	public LazySowedularchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowedularchInfo> translateRecordInfosHook(List<SowedularchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowedularchInfo> getInstanceOfActionHook(DeciTreeOption<SowedularchInfo> option) {
		return new RootSowedularchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowedularchInfo> translateResultHook(DeciResult<SowedularchInfo> result) {
		return result;
	}
}
