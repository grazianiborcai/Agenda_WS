package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeeStoreSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFee extends ActionVisitorTemplateMerge<CartInfo, FeeStoreInfo> {
	
	public VisiCartMergeFee(Connection conn, String schemaName) {
		super(conn, schemaName, FeeStoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeStoreInfo>> getTreeClassHook() {
		return RootFeeStoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
