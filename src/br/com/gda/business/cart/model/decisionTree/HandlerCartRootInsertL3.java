package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartRootInsertL3 extends DeciActionHandlerTemplate<CartInfo, CartInfo> {

	public HandlerCartRootInsertL3(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected DeciAction<CartInfo> getInstanceOfActionHook(DeciTreeOption<CartInfo> option) {
		return new RootCartInsertL3(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<CartInfo> result) {
		return result;
	}
}
