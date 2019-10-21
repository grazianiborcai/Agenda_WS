package br.com.mind5.business.materialTextSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextCopier;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.RootMatextSelect;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatextsnapMergeMatext extends ActionVisitorTemplateMergeV2<MatextsnapInfo, MatextInfo> {
	
	public VisiMatextsnapMergeMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatextsnapInfo> recordInfos) {
		return MatextCopier.copyFromMatextsnap(recordInfos);	
	}	
	
	
	
	@Override protected List<MatextsnapInfo> mergeHook(List<MatextsnapInfo> recordInfos, List<MatextInfo> selectedInfos) {	
		return MatextsnapMerger.mergeWithMatext(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
