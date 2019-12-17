package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialMovementSearch.model.decisionTree.RootMatmarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatmovMergeMatmarch extends ActionVisitorTemplateMergeV2<MatmovInfo, MatmarchInfo> {
	
	public VisiMatmovMergeMatmarch(Connection conn, String schemaName) {
		super(conn, schemaName, MatmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatmarchInfo>> getTreeClassHook() {
		return RootMatmarchSelect.class;
	}
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> recordInfos, List<MatmarchInfo> selectedInfos) {	
		return MatmovMerger.mergeWithMatmarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
