package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatUnitSelect;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMatUnit extends ActionVisitorTemplateMergeV1<MatInfo, MatUnitInfo> {
	
	public VisiMatMergeMatUnit(Connection conn, String schemaName) {
		super(conn, schemaName, MatUnitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatUnitInfo>> getTreeClassHook() {
		return RootMatUnitSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatUnitInfo> selectedInfos) {	
		return MatMerger.mergeWithMatUnit(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
