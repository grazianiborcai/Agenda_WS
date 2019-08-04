package br.com.gda.payment.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipMerger;
import br.com.gda.payment.storePartner.info.StoparCopier;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparSelect;

final class VisiRefumoipMergeStopar extends ActionVisitorTemplateMergeV2<RefumoipInfo, StoparInfo> {
	
	public VisiRefumoipMergeStopar(Connection conn, String schemaName) {
		super(conn, schemaName, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return RootStoparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> toActionClassHook(List<RefumoipInfo> recordInfos) {
		return StoparCopier.copyFromRefumoip(recordInfos);	
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> recordInfos, List<StoparInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithStopar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
