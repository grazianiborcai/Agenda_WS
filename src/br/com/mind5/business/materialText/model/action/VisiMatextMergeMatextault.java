package br.com.mind5.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.decisionTree.RootMatextaultSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatextMergeMatextault extends ActionVisitorTemplateMergeV1<MatextInfo, MatextaultInfo> {
	
	public VisiMatextMergeMatextault(Connection conn, String schemaName) {
		super(conn, schemaName, MatextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextaultInfo>> getTreeClassHook() {
		return RootMatextaultSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> recordInfos, List<MatextaultInfo> selectedInfos) {	
		return MatextMerger.mergeWithMatextault(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
