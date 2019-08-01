package br.com.gda.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.refundOrder.info.RefuInfo;
import br.com.gda.payment.refundOrderItem.info.RefemCopier;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.payment.refundOrderItem.model.decisionTree.RootRefemRefund;

final class VisiRefuRefund extends ActionVisitorTemplateMergeV2<RefuInfo, RefemInfo> {
	
	public VisiRefuRefund(Connection conn, String schemaName) {
		super(conn, schemaName, RefemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefemInfo>> getTreeClassHook() {
		return RootRefemRefund.class;
	}
	
	
	
	protected List<RefemInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return RefemCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> mergeHook(List<RefuInfo> recordInfos, List<RefemInfo> selectedInfos) {	
		return recordInfos;
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
