package br.com.mind5.payment.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.payment.partnerMoip.refundMoip.info.RefumoipMerger;
import br.com.mind5.payment.setupPartner.info.SetuparCopier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

final class VisiRefumoipMergeSetupar extends ActionVisitorTemplateMergeV2<RefumoipInfo, SetuparInfo> {
	
	public VisiRefumoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<RefumoipInfo> recordInfos) {
		return SetuparCopier.copyFromRefumoip(recordInfos);	
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
