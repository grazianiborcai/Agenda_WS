package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootMatGroupSelect;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatGroup extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatGroupInfo> {
	
	public VisiMatsnapMergeMatGroup(Connection conn, String schemaName) {
		super(conn, schemaName, MatGroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatGroupInfo>> getTreeClassHook() {
		return RootMatGroupSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatGroupInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatGroup(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
