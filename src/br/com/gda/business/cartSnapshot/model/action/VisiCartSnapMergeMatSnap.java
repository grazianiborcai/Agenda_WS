package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.info.CartSnapMerger;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatSnapSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeMatSnap extends ActionVisitorTemplateMerge<CartSnapInfo, MatSnapInfo> {
	
	public VisiCartSnapMergeMatSnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatSnapInfo>> getTreeClassHook() {
		return RootMatSnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
