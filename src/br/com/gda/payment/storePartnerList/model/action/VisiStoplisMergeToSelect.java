package br.com.gda.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;
import br.com.gda.payment.storePartnerList.info.StoplisMerger;

final class VisiStoplisMergeToSelect extends ActionVisitorTemplateMergeV2<StoplisInfo, StoplisInfo> {
	
	public VisiStoplisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoplisInfo>> getActionClassHook() {
		return StdStoplisSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> recordInfos, List<StoplisInfo> selectedInfos) {	
		return StoplisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
