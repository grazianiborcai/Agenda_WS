package br.com.mind5.payment.payOrderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.info.PayordarchMerger;

final class VisiPayordarchMergeToSelect extends ActionVisitorTemplateMerge<PayordarchInfo, PayordarchInfo> {
	
	public VisiPayordarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PayordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayordarchInfo>> getActionClassHook() {
		return StdPayordarchSelect.class;
	}
	
	
	
	@Override protected List<PayordarchInfo> mergeHook(List<PayordarchInfo> baseInfos, List<PayordarchInfo> selectedInfos) {	
		return PayordarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
