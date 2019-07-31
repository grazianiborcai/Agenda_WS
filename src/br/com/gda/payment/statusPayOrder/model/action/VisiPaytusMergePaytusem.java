package br.com.gda.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.info.PaytusMerger;
import br.com.gda.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.gda.payment.statusPayOrderItem.model.decisionTree.RootPaytusemSelect;

final class VisiPaytusMergePaytusem extends ActionVisitorTemplateMergeV2<PaytusInfo, PaytusemInfo> {
	
	public VisiPaytusMergePaytusem(Connection conn, String schemaName) {
		super(conn, schemaName, PaytusemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusemInfo>> getTreeClassHook() {
		return RootPaytusemSelect.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<PaytusemInfo> selectedInfos) {	
		return PaytusMerger.mergeWithPaytusem(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
