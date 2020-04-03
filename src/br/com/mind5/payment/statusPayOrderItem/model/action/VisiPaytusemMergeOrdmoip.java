package br.com.mind5.payment.statusPayOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemMerger;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.RootOrdmoipRead;

final class VisiPaytusemMergeOrdmoip extends ActionVisitorTemplateMergeV1<PaytusemInfo, OrdmoipInfo> {
	
	public VisiPaytusemMergeOrdmoip(Connection conn, String schemaName) {
		super(conn, schemaName, OrdmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdmoipInfo>> getTreeClassHook() {
		return RootOrdmoipRead.class;
	}
	
	
	
	@Override protected List<PaytusemInfo> mergeHook(List<PaytusemInfo> baseInfos, List<OrdmoipInfo> selectedInfos) {	
		return PaytusemMerger.mergeWithOrdmoip(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
