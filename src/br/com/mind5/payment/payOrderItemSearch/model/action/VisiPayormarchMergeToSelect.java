package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchMerger;

final class VisiPayormarchMergeToSelect extends ActionVisitorTemplateMergeV2<PayormarchInfo, PayormarchInfo> {
	
	public VisiPayormarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayormarchInfo>> getActionClassHook() {
		return StdPayormarchSelect.class;
	}
	
	
	
	@Override protected List<PayormarchInfo> mergeHook(List<PayormarchInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return PayormarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
