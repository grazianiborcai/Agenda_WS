package br.com.mind5.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdistMergeOrderatus extends ActionLazyTemplateV1<OrdistInfo, OrdistInfo> {

	public LazyOrdistMergeOrderatus(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdistInfo> translateRecordInfosHook(List<OrdistInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrdistInfo> getInstanceOfActionHook(DeciTreeOption<OrdistInfo> option) {
		return new StdOrdistMergeOrderatus(option);
	}
	
	
	
	@Override protected DeciResult<OrdistInfo> translateResultHook(DeciResult<OrdistInfo> result) {
		return result;
	}
}