package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;

public final class LazySteddMergeStolis extends ActionLazyTemplate<StordInfo, StordInfo> {

	public LazySteddMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StordInfo> translateRecordInfosHook(List<StordInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StordInfo> getInstanceOfActionHook(DeciTreeOption<StordInfo> option) {
		return new StdStordMergeStolis(option);
	}
	
	
	
	@Override protected DeciResult<StordInfo> translateResultHook(DeciResult<StordInfo> result) {
		return result;
	}
}
