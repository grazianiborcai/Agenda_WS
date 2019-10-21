package br.com.mind5.business.materialMovement.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatSelect;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.info.MatmovMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatmovMergeMat extends ActionVisitorTemplateMergeV2<MatmovInfo, MatInfo> {
	
	public VisiMatmovMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatmovInfo> mergeHook(List<MatmovInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return MatmovMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
