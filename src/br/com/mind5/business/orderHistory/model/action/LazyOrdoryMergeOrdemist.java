package br.com.mind5.business.orderHistory.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderHistory.info.OrdoryInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdoryMergeOrdemist extends ActionLazyTemplate<OrdoryInfo, OrdoryInfo> {

	public LazyOrdoryMergeOrdemist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdoryInfo> translateRecordInfosHook(List<OrdoryInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdoryInfo> getInstanceOfActionHook(DeciTreeOption<OrdoryInfo> option) {
		return new StdOrdoryMergeOrdemist(option);
	}
	
	
	
	@Override protected DeciResult<OrdoryInfo> translateResultHook(DeciResult<OrdoryInfo> result) {
		return result;
	}
}
