package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchMerger;

final class VisiPayormarchMergeToSelect extends ActionVisitorTemplateMergeV1<PayormarchInfo, PayormarchInfo> {
	
	public VisiPayormarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PayormarchInfo>> getActionClassHook() {
		return StdPayormarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PayormarchInfo> mergeHook(List<PayormarchInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return PayormarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
