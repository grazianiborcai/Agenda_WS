package br.com.gda.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.info.StoparMerger;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparSelect;

final class VisiStoparMergeToDelete extends ActionVisitorTemplateMergeV2<StoparInfo, StoparInfo> {
	
	public VisiStoparMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return RootStoparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> recordInfos, List<StoparInfo> selectedInfos) {	
		return StoparMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
