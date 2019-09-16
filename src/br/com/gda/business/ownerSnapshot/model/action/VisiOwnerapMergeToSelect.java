package br.com.gda.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.info.OwnerapMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOwnerapMergeToSelect extends ActionVisitorTemplateMergeV2<OwnerapInfo, OwnerapInfo> {
	
	public VisiOwnerapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnerapInfo>> getActionClassHook() {
		return StdOwnerapSelect.class;
	}
	
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> recordInfos, List<OwnerapInfo> selectedInfos) {	
		return OwnerapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
