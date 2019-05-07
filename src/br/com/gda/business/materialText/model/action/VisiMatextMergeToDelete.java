package br.com.gda.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialText.info.MatextCopier;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.info.MatextMerger;
import br.com.gda.business.materialText.model.decisionTree.RootMatextSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatextMergeToDelete extends ActionVisitorTemplateMergeV2<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextSelect.class;
	}
	
	
	
	@Override 	protected List<MatextInfo> toActionClassHook(List<MatextInfo> recordInfos) {
		return MatextCopier.copyToDelete(recordInfos);	
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> recordInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
