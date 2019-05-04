package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeeStoreSelectService;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeeStore extends ActionVisitorTemplateMerge_<CartInfo, FeeStoreInfo> {
	
	public VisiCartMergeFeeStore(Connection conn, String schemaName) {
		super(conn, schemaName, FeeStoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeStoreInfo>> getTreeClassHook() {
		return RootFeeStoreSelectService.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
