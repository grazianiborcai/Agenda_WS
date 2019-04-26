package br.com.gda.business.materialMovement.model.action;

import java.sql.Connection;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.info.MatmovMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatmovMergeMat extends ActionVisitorTemplateMerge<MatmovInfo, MatInfo> {
	
	public VisiMatmovMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatmovInfo>> getMergerClassHook() {
		return MatmovMerger.class;
	}
}
