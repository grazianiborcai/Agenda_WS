package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiEmpmarchMergeToSelect extends ActionVisitorTemplateMergeV1<EmpmarchInfo, EmpmarchInfo> {
	
	public VisiEmpmarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmpmarchInfo>> getActionClassHook() {
		return StdEmpmarchSelect.class;
	}
	
	
	
	@Override protected List<EmpmarchInfo> mergeHook(List<EmpmarchInfo> recordInfos, List<EmpmarchInfo> selectedInfos) {	
		return EmpmarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
