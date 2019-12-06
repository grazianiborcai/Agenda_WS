package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.business.materialText.info.MatextCopier;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.decisionTree.RootMatextSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMatext extends ActionVisitorTemplateMergeV2<MatInfo, MatextInfo> {
	
	public VisiMatMergeMatext(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextSearch.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatInfo> baseInfos) {
		return MatextCopier.copyFromMatKey(baseInfos);
	}	
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> recordInfos, List<MatextInfo> selectedInfos) {	
		return MatMerger.mergeWithMatext(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
