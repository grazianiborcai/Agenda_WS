package br.com.gda.payment.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipMerger;
import br.com.gda.payment.setupPartner.info.SetuparCopier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiOrdmoipMergeSetupar extends ActionVisitorTemplateMergeV2<OrdmoipInfo, SetuparInfo> {
	
	public VisiOrdmoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<OrdmoipInfo> recordInfos) {
		return SetuparCopier.copyFromOrdmoip(recordInfos);	
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
