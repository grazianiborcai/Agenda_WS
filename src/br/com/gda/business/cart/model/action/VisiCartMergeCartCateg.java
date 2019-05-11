package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCartCategSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeCartCateg extends ActionVisitorTemplateMerge_<CartInfo, CartCategInfo> {
	
	public VisiCartMergeCartCateg(Connection conn, String schemaName) {
		super(conn, schemaName, CartCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartCategInfo>> getTreeClassHook() {
		return RootCartCategSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
