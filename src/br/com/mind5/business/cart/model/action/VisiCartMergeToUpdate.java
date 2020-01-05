package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiCartMergeToUpdate extends ActionVisitorTemplateMergeV2<CartInfo, CartInfo> {
	
	public VisiCartMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CartInfo>> getActionClassHook() {
		return StdCartSelect.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<CartInfo> selectedInfos) {	
		return CartMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
