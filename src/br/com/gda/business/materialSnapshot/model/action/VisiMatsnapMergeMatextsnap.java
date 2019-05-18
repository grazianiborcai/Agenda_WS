package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapMerger;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.business.materialTextSnapshot.model.decisionTree.RootMatextsnapSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

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
