package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;

public final class LazySowedulSowedulagrUpsert extends ActionLazyTemplate<SowedulInfo, SowedulInfo> {

	public LazySowedulSowedulagrUpsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowedulInfo> translateRecordInfosHook(List<SowedulInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowedulInfo> getInstanceOfActionHook(DeciTreeOption<SowedulInfo> option) {
		return new StdSowedulSowedulagrUpsert(option);
	}
	
	
	
	@Override protected DeciResult<SowedulInfo> translateResultHook(DeciResult<SowedulInfo> result) {
		return result;
	}
}
