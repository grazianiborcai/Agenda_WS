package br.com.mind5.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

final class VisiPayordemMergeToUpdateStatus extends ActionVisitorTemplateMerge<PayordemInfo, PayordemInfo> {
	
	public VisiPayordemMergeToUpdateStatus(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PayordemInfo>> getActionClassHook() {
		return StdPayordemSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {	
		return PayordemMerger.mergeToUpdateStatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
