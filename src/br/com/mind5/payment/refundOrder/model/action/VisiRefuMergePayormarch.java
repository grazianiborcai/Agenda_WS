package br.com.mind5.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchCopier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.RootPayormarchSelect;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.info.RefuMerger;

final class VisiRefuMergePayormarch extends ActionVisitorTemplateMergeV2<RefuInfo, PayormarchInfo> {
	
	public VisiRefuMergePayormarch(Connection conn, String schemaName) {
		super(conn, schemaName, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayormarchInfo>> getTreeClassHook() {
		return RootPayormarchSelect.class;
	}
	
	
	
	@Override protected List<PayormarchInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return PayormarchCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> mergeHook(List<RefuInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return RefuMerger.mergeWithPayormarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
