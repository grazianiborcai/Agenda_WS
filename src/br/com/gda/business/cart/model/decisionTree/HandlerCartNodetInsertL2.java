package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartNodetInsertL2 extends ActionLazyTemplate<CartInfo, CartInfo> {

	public HandlerCartNodetInsertL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartInfo> getInstanceOfActionHook(DeciTreeOption<CartInfo> option) {
		return new NodeCartInsertL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<CartInfo> result) {
		return result;
	}
}
