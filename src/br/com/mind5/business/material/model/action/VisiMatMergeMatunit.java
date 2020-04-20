package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.decisionTree.RootMatunitSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMatunit extends ActionVisitorTemplateMergeV1<MatInfo, MatunitInfo> {
	
	public VisiMatMergeMatunit(Connection conn, String schemaName) {
		super(conn, schemaName, MatunitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatunitInfo>> getTreeClassHook() {
		return RootMatunitSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatunitInfo> selectedInfos) {	
		return MatMerger.mergeWithMatunit(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
