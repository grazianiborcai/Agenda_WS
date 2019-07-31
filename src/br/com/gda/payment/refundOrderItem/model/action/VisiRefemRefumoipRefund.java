package br.com.gda.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.model.decisionTree.RootRefumoipRefund;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemRefumoipRefund extends ActionVisitorTemplateMergeV2<RefemInfo, RefumoipInfo> {
	
	public VisiRefemRefumoipRefund(Connection conn, String schemaName) {
		super(conn, schemaName, RefumoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefumoipInfo>> getTreeClassHook() {
		return RootRefumoipRefund.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> recordInfos, List<RefumoipInfo> selectedInfos) {	
		return RefemMerger.mergeWithRefumoip(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
