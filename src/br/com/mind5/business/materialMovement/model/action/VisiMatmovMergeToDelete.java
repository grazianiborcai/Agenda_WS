package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.business.materialMovement.model.decisionTree.RootMatmovSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatmovMergeToDelete extends ActionVisitorTemplateMergeV2<MatmovInfo, MatmovInfo> {
	
	public VisiMatmovMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatmovInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatmovInfo>> getTreeClassHook() {
		return RootMatmovSelect.class;
	}
	
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> recordInfos, List<MatmovInfo> selectedInfos) {	
		return MatmovMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
