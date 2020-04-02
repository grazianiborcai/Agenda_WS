package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmplateMergeToSelect extends ActionVisitorTemplateMerge<EmplateInfo, EmplateInfo> {
	
	public VisiEmplateMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmplateInfo>> getActionClassHook() {
		return StdEmplateSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> recordInfos, List<EmplateInfo> selectedInfos) {	
		return EmplateMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
