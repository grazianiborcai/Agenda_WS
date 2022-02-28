package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree.RootSowedulagrDelete;

public final class LazySowedulagrRootDelete extends ActionLazyTemplate<SowedulagrInfo, SowedulagrInfo> {

	public LazySowedulagrRootDelete(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowedulagrInfo> translateRecordInfosHook(List<SowedulagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowedulagrInfo> getInstanceOfActionHook(DeciTreeOption<SowedulagrInfo> option) {
		return new RootSowedulagrDelete(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowedulagrInfo> translateResultHook(DeciResult<SowedulagrInfo> result) {
		return result;
	}
}
