package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.setupPartner.info.SetuparCopier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipMerger;

final class VisiCremoipMergeSetupar extends ActionVisitorTemplateMergeV2<CremoipInfo, SetuparInfo> {
	
	public VisiCremoipMergeSetupar(Connection conn, String schemaName) {
		super(conn, schemaName, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return RootSetuparSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<CremoipInfo> recordInfos) {
		return SetuparCopier.copyFromCremoip(recordInfos);	
	}
	
	
	
	@Override protected List<CremoipInfo> mergeHook(List<CremoipInfo> recordInfos, List<SetuparInfo> selectedInfos) {	
		return CremoipMerger.mergeWithSetupar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
