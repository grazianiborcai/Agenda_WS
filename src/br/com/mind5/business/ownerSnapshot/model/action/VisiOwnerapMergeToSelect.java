package br.com.mind5.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOwnerapMergeToSelect extends ActionVisitorTemplateMerge<OwnerapInfo, OwnerapInfo> {
	
	public VisiOwnerapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OwnerapInfo>> getActionClassHook() {
		return StdOwnerapSelect.class;
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> recordInfos, List<OwnerapInfo> selectedInfos) {	
		return OwnerapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
