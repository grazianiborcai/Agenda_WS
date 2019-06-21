package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;
import br.com.gda.payment.payOrder.model.decisionTree.RootPayordSelect;

final class VisiPayordMergeToDelete extends ActionVisitorTemplateMergeV2<PayordInfo, PayordInfo> {
	
	public VisiPayordMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return RootPayordSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<PayordInfo> selectedInfos) {	
		return PayordMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
