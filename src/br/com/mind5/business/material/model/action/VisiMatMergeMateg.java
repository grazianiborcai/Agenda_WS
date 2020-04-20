package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.decisionTree.RootMategSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMateg extends ActionVisitorTemplateMergeV1<MatInfo, MategInfo> {
	
	public VisiMatMergeMateg(Connection conn, String schemaName) {
		super(conn, schemaName, MategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MategInfo>> getTreeClassHook() {
		return RootMategSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MategInfo> selectedInfos) {	
		return MatMerger.mergeWithMateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
