package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class LazyStordiveMergeCalate extends ActionLazyTemplate<StordiveInfo, StordiveInfo> {

	public LazyStordiveMergeCalate(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StordiveInfo> translateRecordInfosHook(List<StordiveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StordiveInfo> getInstanceOfActionHook(DeciTreeOption<StordiveInfo> option) {
		return new StdStordiveMergeCalate(option);
	}
	
	
	
	@Override protected DeciResult<StordiveInfo> translateResultHook(DeciResult<StordiveInfo> result) {
		return result;
	}
}
