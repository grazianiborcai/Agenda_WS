package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMatType extends ActionVisitorTemplateMergeV2<MatInfo, MatTypeInfo> {
	
	public VisiMatMergeMatType(Connection conn, String schemaName) {
		super(conn, schemaName, MatTypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatTypeInfo>> getTreeClassHook() {
		return RootMatTypeSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> recordInfos, List<MatTypeInfo> selectedInfos) {	
		return MatMerger.mergeWithMatType(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
