package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartSelect;
import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.info.CartSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeCart extends ActionVisitorTemplateMerge<CartSnapInfo, CartInfo> {
	
	public VisiCartSnapMergeCart(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartInfo>> getTreeClassHook() {
		return RootCartSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
