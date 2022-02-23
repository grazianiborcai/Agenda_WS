package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class LazyStoronagrMergeCalonth extends ActionLazyTemplate<StoronagrInfo, StoronagrInfo> {

	public LazyStoronagrMergeCalonth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoronagrInfo> translateRecordInfosHook(List<StoronagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoronagrInfo> getInstanceOfActionHook(DeciTreeOption<StoronagrInfo> option) {
		return new StdStoronagrMergeCalonth(option);
	}
	
	
	
	@Override protected DeciResult<StoronagrInfo> translateResultHook(DeciResult<StoronagrInfo> result) {
		return result;
	}
}
