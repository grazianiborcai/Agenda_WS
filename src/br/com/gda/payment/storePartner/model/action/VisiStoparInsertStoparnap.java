package br.com.gda.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.info.StoparMerger;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.model.decisionTree.RootStoparnapInsert;

final class VisiStoparInsertStoparnap extends ActionVisitorTemplateMergeV2<StoparInfo, StoparnapInfo> {
	
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
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
