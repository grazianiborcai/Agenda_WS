package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.RootPayordemistSelect;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipMerger;

final class VisiRefumoipMergePayordemist extends ActionVisitorTemplateMergeV2<RefumoipInfo, PayordemistInfo> {
	
	public VisiRefumoipMergePayordemist(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemistInfo>> getTreeClassHook() {
		return RootPayordemistSelect.class;
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithPayordemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
