package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatType extends ActionVisitorTemplateMerge<MatInfo, MatTypeInfo> {
	
	public VisiMatMergeMatType(Connection conn, String schemaName) {
		super(conn, schemaName, MatTypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatTypeInfo>> getTreeClassHook() {
		return RootMatTypeSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
