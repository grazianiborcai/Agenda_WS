package br.com.mind5.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiStolateMergeToSelect extends ActionVisitorTemplateMergeV2<StolateInfo, StolateInfo> {
	
	public VisiStolateMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolateInfo>> getActionClassHook() {
		return StdStolateSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> recordInfos, List<StolateInfo> selectedInfos) {	
		return StolateMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
