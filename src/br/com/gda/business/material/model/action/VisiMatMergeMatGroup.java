package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatGroupSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatGroup extends ActionVisitorTemplateMerge_<MatInfo, MatGroupInfo> {
	
	public VisiMatMergeMatGroup(Connection conn, String schemaName) {
		super(conn, schemaName, MatGroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatGroupInfo>> getTreeClassHook() {
		return RootMatGroupSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
