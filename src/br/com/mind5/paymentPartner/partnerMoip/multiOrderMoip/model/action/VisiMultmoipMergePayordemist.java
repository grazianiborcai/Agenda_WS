package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.RootPayordemistSearch;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;

final class VisiMultmoipMergePayordemist extends ActionVisitorTemplateMergeV2<MultmoipInfo, PayordemistInfo> {
	
	public VisiMultmoipMergePayordemist(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemistInfo>> getTreeClassHook() {
		return RootPayordemistSearch.class;
	}
	
	
	
	@Override protected List<MultmoipInfo> mergeHook(List<MultmoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return MultmoipMerger.mergeWithPayordemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}