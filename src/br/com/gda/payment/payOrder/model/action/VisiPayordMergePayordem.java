package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;
import br.com.gda.payment.payOrderItem.info.PayordemCopier;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;
import br.com.gda.payment.payOrderItem.model.decisionTree.RootPayordemSelect;

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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
