package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;

public final class LazyStoronStoronagrInsert extends ActionLazyTemplate<StoronInfo, StoronInfo> {

	public LazyStoronStoronagrInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoronInfo> translateRecordInfosHook(List<StoronInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoronInfo> getInstanceOfActionHook(DeciTreeOption<StoronInfo> option) {
		return new StdStoronStoronagrInsert(option);
	}
	
	
	
	@Override protected DeciResult<StoronInfo> translateResultHook(DeciResult<StoronInfo> result) {
		return result;
	}
}
