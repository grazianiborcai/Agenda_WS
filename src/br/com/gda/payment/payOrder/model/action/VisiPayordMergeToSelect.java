package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;

final class VisiPayordMergeToSelect extends ActionVisitorTemplateMergeV2<PayordInfo, PayordInfo> {
	
	public VisiPayordMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayordInfo>> getActionClassHook() {
		return StdPayordSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<PayordInfo> selectedInfos) {	
		return PayordMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
