package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.cart.model.decisionTree.RootCartSelect;
import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.info.CartSnapMerger;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeCart extends ActionVisitorTemplateMerge_<CartSnapInfo, CartInfo> {
	
	public VisiCartSnapMergeCart(Connection conn, String schemaName) {
		super(conn, schemaName, CartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartInfo>> getTreeClassHook() {
		return RootCartSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
