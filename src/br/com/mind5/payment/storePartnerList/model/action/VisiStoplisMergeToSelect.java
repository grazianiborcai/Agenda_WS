package br.com.mind5.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;

final class VisiStoplisMergeToSelect extends ActionVisitorTemplateMerge<StoplisInfo, StoplisInfo> {
	
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
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
