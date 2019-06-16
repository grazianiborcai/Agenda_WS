package br.com.gda.payment.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.info.PaycusMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiPaycusMergeToSelect extends ActionVisitorTemplateMergeV2<PaycusInfo, PaycusInfo> {
	
	public VisiPaycusMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PaycusInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PaycusInfo>> getActionClassHook() {
		return StdPaycusSelect.class;
	}
	
	
	
	@Override protected List<PaycusInfo> mergeHook(List<PaycusInfo> recordInfos, List<PaycusInfo> selectedInfos) {	
		return PaycusMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
