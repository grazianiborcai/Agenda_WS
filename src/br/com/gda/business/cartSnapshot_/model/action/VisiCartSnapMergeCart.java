package br.com.gda.business.cartSnapshot_.model.action;

import java.sql.Connection;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot_.info.CartSnapMerger;
import br.com.gda.business.cart.model.decisionTree.RootCartSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeCart extends ActionVisitorTemplateMerge_<CartSnapInfo, CartemInfo> {
	
	public VisiCartSnapMergeCart(Connection conn, String schemaName) {
		super(conn, schemaName, CartemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemInfo>> getTreeClassHook() {
		return RootCartSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
