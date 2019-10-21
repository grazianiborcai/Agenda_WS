package br.com.mind5.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapMerger;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.business.materialTextSnapshot.model.decisionTree.RootMatextsnapSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatsnapMergeMatextsnap extends ActionVisitorTemplateMergeV2<MatsnapInfo, MatextsnapInfo> {
	
	public VisiMatsnapMergeMatextsnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextsnapInfo>> getTreeClassHook() {
		return RootMatextsnapSelect.class;
	}
	
	
	
	@Override protected List<MatsnapInfo> mergeHook(List<MatsnapInfo> recordInfos, List<MatextsnapInfo> selectedInfos) {	
		return MatsnapMerger.mergeWithMatextsnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
