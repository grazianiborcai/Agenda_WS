package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree.RootStordUpsert;

public final class LazySteddRootUpsert extends ActionLazyTemplate<StordInfo, StordInfo> {

	public LazySteddRootUpsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StordInfo> translateRecordInfosHook(List<StordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StordInfo> getInstanceOfActionHook(DeciTreeOption<StordInfo> option) {
		return new RootStordUpsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StordInfo> translateResultHook(DeciResult<StordInfo> result) {
		return result;
	}
}
