package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmplateMergeToUpdate extends ActionVisitorTemplateMergeV2<EmplateInfo, EmplateInfo> {
	
	public VisiEmplateMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, EmplateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplateInfo>> getActionClassHook() {
		return StdEmplateSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> recordInfos, List<EmplateInfo> selectedInfos) {	
		return EmplateMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
