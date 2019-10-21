package br.com.mind5.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdistMergeOrderStatus extends ActionLazyTemplate<OrdistInfo, OrdistInfo> {

	public LazyOrdistMergeOrderStatus(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdistInfo> translateRecordInfosHook(List<OrdistInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdistInfo> getInstanceOfActionHook(DeciTreeOption<OrdistInfo> option) {
		return new StdOrdistMergeOrderStatus(option);
	}
	
	
	
	@Override protected DeciResult<OrdistInfo> translateResultHook(DeciResult<OrdistInfo> result) {
		return result;
	}
}
