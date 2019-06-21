package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.payment.storePartnerSnapshot.model.decisionTree.RootStoparnapInsert;

final class VisiPayordInsertStoparnap extends ActionVisitorTemplateMergeV2<PayordInfo, StoparnapInfo> {
	
	public VisiPayordInsertStoparnap(Connection conn, String schemaName) {
		super(conn, schemaName, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparnapInfo>> getTreeClassHook() {
		return RootStoparnapInsert.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<StoparnapInfo> selectedInfos) {	
		return PayordMerger.mergeWithStoparnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
