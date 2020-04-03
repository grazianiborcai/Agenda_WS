package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiStolargMergeToSelect extends ActionVisitorTemplateMergeV1<StolargInfo, StolargInfo> {
	
	public VisiStolargMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<StolargInfo>> getActionClassHook() {
		return StdStolargSelect.class;
	}
	
	
	
	@Override protected List<StolargInfo> mergeHook(List<StolargInfo> recordInfos, List<StolargInfo> selectedInfos) {	
		return StolargMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
