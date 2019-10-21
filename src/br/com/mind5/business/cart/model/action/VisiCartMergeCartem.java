package br.com.mind5.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.info.CartMerger;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.decisionTree.RootCartemSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCartMergeCartem extends ActionVisitorTemplateMergeV2<CartInfo, CartemInfo> {
	
	public VisiCartMergeCartem(Connection conn, String schemaName) {
		super(conn, schemaName, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return RootCartemSelect.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<CartemInfo> selectedInfos) {	
		return CartMerger.mergeWithCartem(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
