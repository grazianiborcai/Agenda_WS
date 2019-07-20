package br.com.gda.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.payOrderItem.info.PayordemMerger;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class VisiPayordemMergeToUpdate extends ActionVisitorTemplateMergeV2<PayordemInfo, PayordemInfo> {
	
	public VisiPayordemMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayordemInfo>> getActionClassHook() {
		return StdPayordemSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> recordInfos, List<PayordemInfo> selectedInfos) {	
		return PayordemMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
