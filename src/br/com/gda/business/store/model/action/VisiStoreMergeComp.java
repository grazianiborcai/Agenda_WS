package br.com.gda.business.store.model.action;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.decisionTree.RootCompSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStoreMergeComp extends ActionVisitorTemplateMerge<StoreInfo, CompInfo> {
	
	public VisiStoreMergeComp(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return RootCompSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<StoreInfo>> getMergerClassHook() {
		return StoreMerger.class;
	}
}
