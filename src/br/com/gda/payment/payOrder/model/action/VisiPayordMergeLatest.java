package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;
import br.com.gda.payment.payOrderSearch.model.decisionTree.RootPayordarchLatest;

final class VisiPayordMergeLatest extends ActionVisitorTemplateMergeV2<PayordInfo, PayordarchInfo> {
	
	public VisiPayordMergeLatest(Connection conn, String schemaName) {
		super(conn, schemaName, PayordarchInfo.class);
	}
	
	
	
	@Override protected Class<RootPayordarchLatest> getTreeClassHook() {
		return RootPayordarchLatest.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<PayordarchInfo> selectedInfos) {	
		return PayordMerger.mergeWithLatest(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
