package br.com.mind5.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.RootPayormarchSelect;

final class VisiPayordemMergePayormarch extends ActionVisitorTemplateMergeV2<PayordemInfo, PayormarchInfo> {
	
	public VisiPayordemMergePayormarch(Connection conn, String schemaName) {
		super(conn, schemaName, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayormarchInfo>> getTreeClassHook() {
		return RootPayormarchSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return PayordemMerger.mergeWithPayormarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
