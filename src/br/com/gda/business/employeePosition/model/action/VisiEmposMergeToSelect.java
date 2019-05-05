package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.info.EmposMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmposMergeToSelect extends ActionVisitorTemplateMergeV2<EmposInfo, EmposInfo> {
	
	public VisiEmposMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmposInfo>> getActionClassHook() {
		return StdEmposSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> recordInfos, List<EmposInfo> selectedInfos) {	
		return EmposMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
