package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatGroupSelect;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMatGroup extends ActionVisitorTemplateMergeV2<MatInfo, MatGroupInfo> {
	
	public VisiMatMergeMatGroup(Connection conn, String schemaName) {
		super(conn, schemaName, MatGroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatGroupInfo>> getTreeClassHook() {
		return RootMatGroupSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> recordInfos, List<MatGroupInfo> selectedInfos) {	
		return MatMerger.mergeWithMatGroup(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
