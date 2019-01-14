package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.info.MatSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatSnapMergeMatUnit extends ActionVisitorTemplateMerge<MatSnapInfo, MatUnitInfo> {
	
	public VisiMatSnapMergeMatUnit(Connection conn, String schemaName) {
		super(conn, schemaName, MatUnitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatUnitInfo>> getTreeClassHook() {
		return RootMatUnitSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatSnapInfo>> getMergerClassHook() {
		return MatSnapMerger.class;
	}
}
