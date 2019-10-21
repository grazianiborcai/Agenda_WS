package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.payment.payOrderItem.info.PayordemCopier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.RootPayordemSelect;

final class VisiPayordMergePayordem extends ActionVisitorTemplateMergeV2<PayordInfo, PayordemInfo> {
	
	public VisiPayordMergePayordem(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return RootPayordemSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return PayordemCopier.copyFromPayordToRead(recordInfos);	
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<PayordemInfo> selectedInfos) {	
		return PayordMerger.mergeWithPayordem(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
