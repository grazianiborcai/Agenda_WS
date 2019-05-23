package br.com.gda.business.cartItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.cartItem.info.CartMerger;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeeDefaultSelectService;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeeDefault extends ActionVisitorTemplateMergeV2<CartInfo, FeeDefaultInfo> {
	
	public VisiCartMergeFeeDefault(Connection conn, String schemaName) {
		super(conn, schemaName, FeeDefaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeDefaultInfo>> getTreeClassHook() {
		return RootFeeDefaultSelectService.class;
	}
	
	
	
	@Override protected List<CartInfo> mergeHook(List<CartInfo> recordInfos, List<FeeDefaultInfo> selectedInfos) {	
		return CartMerger.mergeWithFeeDefault(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
