package br.com.mind5.payment.storePartnerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchMerger;

final class VisStoparchMergeToSelect extends ActionVisitorTemplateMerge<StoparchInfo, StoparchInfo> {
	
	public VisStoparchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoparchInfo>> getActionClassHook() {
		return StdStoparchSelect.class;
	}
	
	
	
	@Override protected List<StoparchInfo> mergeHook(List<StoparchInfo> baseInfos, List<StoparchInfo> selectedInfos) {	
		return StoparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
