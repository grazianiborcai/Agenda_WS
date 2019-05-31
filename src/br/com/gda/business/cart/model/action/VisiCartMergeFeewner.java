package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.decisionTree.RootFeewnerSelectService;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeewner extends ActionVisitorTemplateMergeV2<CartInfo, FeewnerInfo> {
	
	public VisiCartMergeFeewner(Connection conn, String schemaName) {
		super(conn, schemaName, FeewnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeewnerInfo>> getTreeClassHook() {
		return RootFeewnerSelectService.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<FeewnerInfo> selectedInfos) {	
		return CartMerger.mergeWithFeewner(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
