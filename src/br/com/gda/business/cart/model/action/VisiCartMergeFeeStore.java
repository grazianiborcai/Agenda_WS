package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeetoreSelectService;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeeStore extends ActionVisitorTemplateMerge_<CartInfo, FeetoreInfo> {
	
	public VisiCartMergeFeeStore(Connection conn, String schemaName) {
		super(conn, schemaName, FeetoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeetoreInfo>> getTreeClassHook() {
		return RootFeetoreSelectService.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
