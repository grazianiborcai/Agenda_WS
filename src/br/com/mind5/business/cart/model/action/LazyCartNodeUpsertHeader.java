package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.decisionTree.NodeCartUpsertHeader;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyCartNodeUpsertHeader extends ActionLazyTemplateV2<CartInfo, CartInfo> {
	
	public LazyCartNodeUpsertHeader(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<CartInfo> getInstanceOfActionHook(DeciTreeOption<CartInfo> option) {
		return new NodeCartUpsertHeader(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<CartInfo> result) {
		return result;
	}
}
