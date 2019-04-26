package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeMatUnit extends ActionVisitorTemplateMerge<MatInfo, MatUnitInfo> {
	
	public VisiMatMergeMatUnit(Connection conn, String schemaName) {
		super(conn, schemaName, MatUnitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatUnitInfo>> getTreeClassHook() {
		return RootMatUnitSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
