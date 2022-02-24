package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree.RootSowordagrInsert;

public final class LazySowordagrRootInsert extends ActionLazyTemplate<SowordagrInfo, SowordagrInfo> {

	public LazySowordagrRootInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SowordagrInfo> translateRecordInfosHook(List<SowordagrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SowordagrInfo> getInstanceOfActionHook(DeciTreeOption<SowordagrInfo> option) {
		return new RootSowordagrInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SowordagrInfo> translateResultHook(DeciResult<SowordagrInfo> result) {
		return result;
	}
}
