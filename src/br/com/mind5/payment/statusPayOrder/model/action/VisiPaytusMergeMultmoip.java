package br.com.mind5.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree.RootMultmoipRead;

final class VisiPaytusMergeMultmoip extends ActionVisitorTemplateMergeV2<PaytusInfo, MultmoipInfo> {
	
	public VisiPaytusMergeMultmoip(Connection conn, String schemaName) {
		super(conn, schemaName, MultmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MultmoipInfo>> getTreeClassHook() {
		return RootMultmoipRead.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<MultmoipInfo> selectedInfos) {	
		return PaytusMerger.mergeWithMultmoip(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
