package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class LazyStordagrEnforceLChanged extends ActionLazyTemplate<StordagrInfo, StordagrInfo> {

	public LazyStordagrEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StordagrInfo> translateRecordInfosHook(List<StordagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StordagrInfo> getInstanceOfActionHook(DeciTreeOption<StordagrInfo> option) {
		return new StdStordagrEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<StordagrInfo> translateResultHook(DeciResult<StordagrInfo> result) {
		return result;
	}
}
