package br.com.gda.payment.payOrderItemStatus.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.decisionTree.RootPayordemUpdateStatus;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemInfo;
import br.com.gda.payment.payOrderItemStatus.info.PaytusemMerger;

final class VisiPaytusemPayordemUpdate extends ActionVisitorTemplateMergeV2<PaytusemInfo, PayordemInfo> {
	
	public VisiPaytusemPayordemUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return RootPayordemUpdateStatus.class;
	}
	
	
	
	@Override protected List<PaytusemInfo> mergeHook(List<PaytusemInfo> recordInfos, List<PayordemInfo> selectedInfos) {	
		return PaytusemMerger.mergeWithPayordem(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
