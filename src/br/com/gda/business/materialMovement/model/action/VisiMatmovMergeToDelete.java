package br.com.gda.business.materialMovement.model.action;

import java.sql.Connection;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.info.MatmovMerger;
import br.com.gda.business.materialMovement.model.decisionTree.RootMatmovSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatmovMergeToDelete extends ActionVisitorTemplateMerge_<MatmovInfo, MatmovInfo> {
	
	public VisiMatmovMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatmovInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatmovInfo>> getTreeClassHook() {
		return RootMatmovSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatmovInfo>> getMergerClassHook() {
		return MatmovMerger.class;
	}
}
