package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeetoreSelectService;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeetore extends ActionVisitorTemplateMergeV2<CartInfo, FeetoreInfo> {
	
	public VisiCartMergeFeetore(Connection conn, String schemaName) {
		super(conn, schemaName, FeetoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeetoreInfo>> getTreeClassHook() {
		return RootFeetoreSelectService.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<FeetoreInfo> selectedInfos) {	
		return CartMerger.mergeWithFeetore(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
