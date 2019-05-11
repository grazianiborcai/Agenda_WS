package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.info.MatSnapMerger;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatSnapMergeMatCateg extends ActionVisitorTemplateMerge_<MatSnapInfo, MatCategInfo> {
	
	public VisiMatSnapMergeMatCateg(Connection conn, String schemaName) {
		super(conn, schemaName, MatCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatCategInfo>> getTreeClassHook() {
		return RootMatCategSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatSnapInfo>> getMergerClassHook() {
		return MatSnapMerger.class;
	}
}
