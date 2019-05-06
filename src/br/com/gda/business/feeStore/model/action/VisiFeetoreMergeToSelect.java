package br.com.gda.business.feeStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.info.FeetoreMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiFeetoreMergeToSelect extends ActionVisitorTemplateMergeV2<FeetoreInfo, FeetoreInfo> {

	public VisiFeetoreMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, FeetoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FeetoreInfo>> getActionClassHook() {
		return StdFeetoreSelect.class;
	}
	
	
	
	@Override protected List<FeetoreInfo> mergeHook(List<FeetoreInfo> recordInfos, List<FeetoreInfo> selectedInfos) {	
		return FeetoreMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
