package br.com.mind5.business.cartCounter.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartouEnforceItemCounter extends ActionLazyTemplate<CartouInfo, CartouInfo> {

	public LazyCartouEnforceItemCounter(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartouInfo> translateRecordInfosHook(List<CartouInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartouInfo> getInstanceOfActionHook(DeciTreeOption<CartouInfo> option) {
		return new StdCartouEnforceItemCounter(option);
	}
	
	
	
	@Override protected DeciResult<CartouInfo> translateResultHook(DeciResult<CartouInfo> result) {
		return result;
	}
}
