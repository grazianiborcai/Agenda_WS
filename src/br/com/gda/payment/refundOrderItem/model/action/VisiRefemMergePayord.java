package br.com.gda.payment.refundOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.decisionTree.RootPayordSelect;
import br.com.gda.payment.refundOrderItem.info.RefemInfo;
import br.com.gda.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemMergePayord extends ActionVisitorTemplateMergeV2<RefemInfo, PayordInfo> {
	
	public VisiRefemMergePayord(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return RootPayordSelect.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> recordInfos, List<PayordInfo> selectedInfos) {	
		return RefemMerger.mergeWithPayord(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
