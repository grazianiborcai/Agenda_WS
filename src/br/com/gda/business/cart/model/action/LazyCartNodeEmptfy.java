package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.NodeCartEmptfy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCartNodeEmptfy extends ActionLazyTemplate<CartInfo, CartInfo> {
	
	public LazyCartNodeEmptfy(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartInfo> getInstanceOfActionHook(DeciTreeOption<CartInfo> option) {
		return new NodeCartEmptfy(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<CartInfo> result) {
		return result;
	}
}
