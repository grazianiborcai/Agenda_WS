package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreMerger;
import br.com.gda.business.materialStore.model.decisionTree.RootMatoreSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatoreMergeToDelete extends ActionVisitorTemplateMerge<MatoreInfo, MatoreInfo> {
	
	public VisiMatoreMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return RootMatoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatoreInfo>> getMergerClassHook() {
		return MatoreMerger.class;
	}
}
