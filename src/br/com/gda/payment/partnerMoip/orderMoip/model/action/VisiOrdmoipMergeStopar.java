package br.com.gda.payment.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipMerger;
import br.com.gda.payment.storePartner.info.StoparCopier;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparSelect;

final class VisiOrdmoipMergeStopar extends ActionVisitorTemplateMergeV2<OrdmoipInfo, StoparInfo> {
	
	public VisiOrdmoipMergeStopar(Connection conn, String schemaName) {
		super(conn, schemaName, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return RootStoparSelect.class;
	}
	
	
	
	protected List<StoparInfo> toActionClassHook(List<OrdmoipInfo> recordInfos) {
		return StoparCopier.copyFromOrdmoip(recordInfos);
	}	
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> recordInfos, List<StoparInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithStopar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
