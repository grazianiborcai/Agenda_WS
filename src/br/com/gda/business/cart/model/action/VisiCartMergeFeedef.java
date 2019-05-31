package br.com.gda.business.cart.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeedefSelectService;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeedef extends ActionVisitorTemplateMergeV2<CartInfo, FeedefInfo> {
	
	public VisiCartMergeFeedef(Connection conn, String schemaName) {
		super(conn, schemaName, FeedefInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeedefInfo>> getTreeClassHook() {
		return RootFeedefSelectService.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<FeedefInfo> selectedInfos) {	
		return CartMerger.mergeWithFeedef(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
