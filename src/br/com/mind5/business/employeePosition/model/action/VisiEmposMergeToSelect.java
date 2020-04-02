package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmposMergeToSelect extends ActionVisitorTemplateMerge<EmposInfo, EmposInfo> {
	
	public VisiEmposMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmposInfo>> getActionClassHook() {
		return StdEmposSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {	
		return EmposMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}	
}
