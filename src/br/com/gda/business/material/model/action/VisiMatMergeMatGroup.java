package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatGroupSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatGroup extends ActionVisitorTemplateMerge<MatInfo, MatGroupInfo> {
	
	public VisiMatMergeMatGroup(Connection conn, String schemaName) {
		super(conn, schemaName, MatGroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatGroupInfo>> getTreeClassHook() {
		return RootMatGroupSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
