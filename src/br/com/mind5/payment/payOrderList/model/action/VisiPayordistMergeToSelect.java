package br.com.mind5.payment.payOrderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.info.PayordistMerger;

final class VisiPayordistMergeToSelect extends ActionVisitorTemplateMergeV1<PayordistInfo, PayordistInfo> {
	
	public VisiPayordistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PayordistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PayordistInfo>> getActionClassHook() {
		return StdPayordistSelect.class;
	}
	
	
	
	@Override protected List<PayordistInfo> mergeHook(List<PayordistInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return PayordistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
