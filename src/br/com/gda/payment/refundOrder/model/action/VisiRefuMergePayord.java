package br.com.gda.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.decisionTree.RootPayordSelect;
import br.com.gda.payment.refundOrder.info.RefuInfo;
import br.com.gda.payment.refundOrder.info.RefuMerger;

final class VisiRefuMergePayord extends ActionVisitorTemplateMergeV2<RefuInfo, PayordInfo> {
	
	public VisiRefuMergePayord(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return RootPayordSelect.class;
	}
	
	
	
	@Override protected List<RefuInfo> mergeHook(List<RefuInfo> recordInfos, List<PayordInfo> selectedInfos) {	
		return RefuMerger.mergeWithPayord(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
