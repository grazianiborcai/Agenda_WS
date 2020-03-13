package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatMergeMatCateg extends ActionVisitorTemplateMergeV2<MatInfo, MatCategInfo> {
	
	public VisiMatMergeMatCateg(Connection conn, String schemaName) {
		super(conn, schemaName, MatCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatCategInfo>> getTreeClassHook() {
		return RootMatCategSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> baseInfos, List<MatCategInfo> selectedInfos) {	
		return MatMerger.mergeWithMatCateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
