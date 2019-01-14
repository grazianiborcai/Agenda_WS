package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.info.CartSnapMerger;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeStore extends ActionVisitorTemplateMerge<CartSnapInfo, StoreInfo> {
	
	public VisiCartSnapMergeStore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return RootStoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
