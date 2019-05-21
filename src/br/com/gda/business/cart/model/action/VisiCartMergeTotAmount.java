package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.totalAmount.model.decisionTree.RootTotAmountCompute;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeTotAmount extends ActionVisitorTemplateMergeV2<CartInfo, TotAmountInfo> {
	
	public VisiCartMergeTotAmount(Connection conn, String schemaName) {
		super(conn, schemaName, TotAmountInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TotAmountInfo>> getTreeClassHook() {
		return RootTotAmountCompute.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<TotAmountInfo> selectedInfos) {	
		return CartMerger.mergeWithTotAmount(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
