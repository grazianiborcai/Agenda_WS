package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatCateg extends ActionVisitorTemplateMerge_<MatInfo, MatCategInfo> {
	
	public VisiMatMergeMatCateg(Connection conn, String schemaName) {
		super(conn, schemaName, MatCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatCategInfo>> getTreeClassHook() {
		return RootMatCategSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
