package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeToDelete extends ActionVisitorTemplateMerge<MatInfo, MatInfo> {
	
	public VisiMatMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
