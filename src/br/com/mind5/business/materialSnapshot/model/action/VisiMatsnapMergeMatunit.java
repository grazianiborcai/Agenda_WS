package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.masterData.materialUnit.model.decisionTree.RootMatunitSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatunit extends ActionVisitorTemplateMergeV1<MatsnapInfo, MatunitInfo> {
	
	public VisiMatsnapMergeMatunit(Connection conn, String schemaName) {
		super(conn, schemaName, MatunitInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatunitInfo>> getTreeClassHook() {
		return RootMatunitSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatunitInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatunit(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
