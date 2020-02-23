package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.decisionTree.RootPayordistSelect;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipMerger;

final class VisiOrdmoipMergePayordist extends ActionVisitorTemplateMergeV2<OrdmoipInfo, PayordistInfo> {
	
	public VisiOrdmoipMergePayordist(Connection conn, String schemaName) {
		super(conn, schemaName, PayordistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordistInfo>> getTreeClassHook() {
		return RootPayordistSelect.class;
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithPayordist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
