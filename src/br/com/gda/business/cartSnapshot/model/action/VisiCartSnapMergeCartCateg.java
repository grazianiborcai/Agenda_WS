package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.info.CartSnapMerger;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCartCategSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeCartCateg extends ActionVisitorTemplateMerge_<CartSnapInfo, CartCategInfo> {
	
	public VisiCartSnapMergeCartCateg(Connection conn, String schemaName) {
		super(conn, schemaName, CartCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartCategInfo>> getTreeClassHook() {
		return RootCartCategSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
