package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class LazyStoroniveEnforceLChanged extends ActionLazyTemplate<StoroniveInfo, StoroniveInfo> {

	public LazyStoroniveEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoroniveInfo> translateRecordInfosHook(List<StoroniveInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StoroniveInfo> getInstanceOfActionHook(DeciTreeOption<StoroniveInfo> option) {
		return new StdStoroniveEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<StoroniveInfo> translateResultHook(DeciResult<StoroniveInfo> result) {
		return result;
	}
}
