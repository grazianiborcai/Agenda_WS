package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.NodeCartCartem;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartNodeCartem extends ActionLazyTemplate<CartInfo, CartInfo> {
	
	public LazyCartNodeCartem(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CartInfo> getInstanceOfActionHook(DeciTreeOption<CartInfo> option) {
		return new NodeCartCartem(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<CartInfo> result) {
		return result;
	}
}
