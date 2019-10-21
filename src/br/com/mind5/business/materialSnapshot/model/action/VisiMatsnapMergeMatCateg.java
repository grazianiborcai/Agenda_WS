package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatCategSelect;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatCateg extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatCategInfo> {
	
	public VisiMatsnapMergeMatCateg(Connection conn, String schemaName) {
		super(conn, schemaName, MatCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatCategInfo>> getTreeClassHook() {
		return RootMatCategSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatCategInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatCateg(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
