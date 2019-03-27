package br.com.gda.business.material.model.action;

import java.sql.Connection;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.decisionTree.RootMatextSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatext extends ActionVisitorTemplateMerge<MatInfo, MatextInfo> {
	
	public VisiMatMergeMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
