package br.com.mind5.business.materialList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.info.MatlisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatlisMergeMatCateg extends ActionVisitorTemplateMergeV2<MatlisInfo, MatCategInfo> {
	
	public VisiMatlisMergeMatCateg(Connection conn, String schemaName) {
		super(conn, schemaName, MatCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatCategInfo>> getTreeClassHook() {
		return RootMatCategSelect.class;
	}
	
	
	
	@Override protected List<MatlisInfo> mergeHook(List<MatlisInfo> baseInfos, List<MatCategInfo> selectedInfos) {	
		return MatlisMerger.mergeWithMatCateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
