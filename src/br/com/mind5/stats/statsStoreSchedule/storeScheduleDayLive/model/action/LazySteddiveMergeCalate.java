package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

public final class LazySteddiveMergeCalate extends ActionLazyTemplate<SteddiveInfo, SteddiveInfo> {

	public LazySteddiveMergeCalate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SteddiveInfo> translateRecordInfosHook(List<SteddiveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SteddiveInfo> getInstanceOfActionHook(DeciTreeOption<SteddiveInfo> option) {
		return new StdSteddiveMergeCalate(option);
	}
	
	
	
	@Override protected DeciResult<SteddiveInfo> translateResultHook(DeciResult<SteddiveInfo> result) {
		return result;
	}
}
