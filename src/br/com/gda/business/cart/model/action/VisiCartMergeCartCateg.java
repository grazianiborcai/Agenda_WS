package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCartCategSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeCartCateg extends ActionVisitorTemplateMergeV2<CartInfo, CartCategInfo> {
	
	public VisiCartMergeCartCateg(Connection conn, String schemaName) {
		super(conn, schemaName, CartCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartCategInfo>> getTreeClassHook() {
		return RootCartCategSelect.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<CartCategInfo> selectedInfos) {	
		return CartMerger.mergeWithCartCateg(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
