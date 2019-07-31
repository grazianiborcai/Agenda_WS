package br.com.gda.payment.statusPayOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree.RootOrdmoipRead;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemMerger;

final class VisiPaytusemMergeOrdmoip extends ActionVisitorTemplateMergeV2<PaytusemInfo, OrdmoipInfo> {
	
	public VisiPaytusemMergeOrdmoip(Connection conn, String schemaName) {
		super(conn, schemaName, OrdmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdmoipInfo>> getTreeClassHook() {
		return RootOrdmoipRead.class;
	}
	
	
	
	@Override protected List<PaytusemInfo> mergeHook(List<PaytusemInfo> recordInfos, List<OrdmoipInfo> selectedInfos) {	
		return PaytusemMerger.mergeWithOrdmoip(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
