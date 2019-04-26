package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeMat extends ActionVisitorTemplateMerge<CartInfo, MatInfo> {
	
	public VisiCartMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
