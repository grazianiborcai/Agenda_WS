package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.model.decisionTree.RootStedmoniveSelect;

public final class LazyStedmoniveRootSelect extends ActionLazyTemplate<StedmoniveInfo, StedmoniveInfo> {

	public LazyStedmoniveRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StedmoniveInfo> translateRecordInfosHook(List<StedmoniveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StedmoniveInfo> getInstanceOfActionHook(DeciTreeOption<StedmoniveInfo> option) {
		return new RootStedmoniveSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StedmoniveInfo> translateResultHook(DeciResult<StedmoniveInfo> result) {
		return result;
	}
}
