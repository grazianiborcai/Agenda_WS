package br.com.mind5.business.orderHistoryDecorated.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderHistoryDecorated.info.OrdorycoInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdorycoMergeOrdorySearchAuth extends ActionLazyTemplate<OrdorycoInfo, OrdorycoInfo> {

	public LazyOrdorycoMergeOrdorySearchAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdorycoInfo> translateRecordInfosHook(List<OrdorycoInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdorycoInfo> getInstanceOfActionHook(DeciTreeOption<OrdorycoInfo> option) {
		return new StdOrdorycoMergeOrdorySearchAuth(option);
	}
	
	
	
	@Override protected DeciResult<OrdorycoInfo> translateResultHook(DeciResult<OrdorycoInfo> result) {
		return result;
	}
}
