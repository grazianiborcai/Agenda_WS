package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree.RootStoronSelect;

public final class LazyStoronRootSelect extends ActionLazyTemplate<StoronInfo, StoronInfo> {

	public LazyStoronRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoronInfo> translateRecordInfosHook(List<StoronInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoronInfo> getInstanceOfActionHook(DeciTreeOption<StoronInfo> option) {
		return new RootStoronSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StoronInfo> translateResultHook(DeciResult<StoronInfo> result) {
		return result;
	}
}
