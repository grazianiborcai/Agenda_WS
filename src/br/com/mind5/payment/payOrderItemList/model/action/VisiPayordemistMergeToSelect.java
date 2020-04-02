package br.com.mind5.payment.payOrderItemList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistMerger;

final class VisiPayordemistMergeToSelect extends ActionVisitorTemplateMerge<PayordemistInfo, PayordemistInfo> {
	
	public VisiPayordemistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PayordemistInfo>> getActionClassHook() {
		return StdPayordemistSelect.class;
	}
	
	
	
	@Override protected List<PayordemistInfo> mergeHook(List<PayordemistInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return PayordemistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
