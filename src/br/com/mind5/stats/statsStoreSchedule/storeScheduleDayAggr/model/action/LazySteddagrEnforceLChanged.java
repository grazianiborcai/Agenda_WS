package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class LazySteddagrEnforceLChanged extends ActionLazyTemplate<SteddagrInfo, SteddagrInfo> {

	public LazySteddagrEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SteddagrInfo> translateRecordInfosHook(List<SteddagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SteddagrInfo> getInstanceOfActionHook(DeciTreeOption<SteddagrInfo> option) {
		return new StdSteddagrEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<SteddagrInfo> translateResultHook(DeciResult<SteddagrInfo> result) {
		return result;
	}
}
