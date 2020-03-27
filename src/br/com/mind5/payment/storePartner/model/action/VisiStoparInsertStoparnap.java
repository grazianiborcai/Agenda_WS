package br.com.mind5.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.model.decisionTree.RootStoparnapInsert;

final class VisiStoparInsertStoparnap extends ActionVisitorTemplateMerge<StoparInfo, StoparnapInfo> {
	
	public VisiStoparInsertStoparnap(Connection conn, String schemaName) {
		super(conn, schemaName, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparnapInfo>> getTreeClassHook() {
		return RootStoparnapInsert.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> recordInfos, List<StoparnapInfo> selectedInfos) {	
		return StoparMerger.mergeWithStoparnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
