package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatType extends ActionVisitorTemplateMerge_<MatInfo, MatTypeInfo> {
	
	public VisiMatMergeMatType(Connection conn, String schemaName) {
		super(conn, schemaName, MatTypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatTypeInfo>> getTreeClassHook() {
		return RootMatTypeSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
