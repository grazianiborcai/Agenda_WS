package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCartMergeToSelect extends ActionVisitorTemplateMerge<CartInfo, CartInfo> {
	
	public VisiCartMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CartInfo>> getActionClassHook() {
		return StdCartSelect.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> baseInfos, List<CartInfo> selectedInfos) {	
		return CartMerger.mergeToSelect(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
