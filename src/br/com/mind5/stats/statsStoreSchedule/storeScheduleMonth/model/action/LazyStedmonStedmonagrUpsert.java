package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;

public final class LazyStedmonStedmonagrUpsert extends ActionLazyTemplate<StedmonInfo, StedmonInfo> {

	public LazyStedmonStedmonagrUpsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StedmonInfo> translateRecordInfosHook(List<StedmonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StedmonInfo> getInstanceOfActionHook(DeciTreeOption<StedmonInfo> option) {
		return new StdStedmonStedmonagrUpsert(option);
	}
	
	
	
	@Override protected DeciResult<StedmonInfo> translateResultHook(DeciResult<StedmonInfo> result) {
		return result;
	}
}
