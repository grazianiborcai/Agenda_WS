package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiStolargMergeToSelect extends ActionVisitorTemplateMerge<StolargInfo, StolargInfo> {
	
	public VisiStolargMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolargInfo>> getActionClassHook() {
		return StdStolargSelect.class;
	}
	
	
	
	@Override protected List<StolargInfo> mergeHook(List<StolargInfo> recordInfos, List<StolargInfo> selectedInfos) {	
		return StolargMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
