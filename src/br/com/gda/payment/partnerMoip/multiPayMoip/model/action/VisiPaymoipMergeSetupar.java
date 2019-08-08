package br.com.gda.payment.partnerMoip.multiPayMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipMerger;
import br.com.gda.payment.setupPartner.info.SetuparCopier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiPaymoipMergeSetupar extends ActionVisitorTemplateMergeV2<PaymoipInfo, SetuparInfo> {
	
	public VisiPaymoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<PaymoipInfo> recordInfos) {
		return SetuparCopier.copyFromPaymoip(recordInfos);	
	}
	
	
	
	@Override protected List<PaymoipInfo> mergeHook(List<PaymoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return PaymoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
