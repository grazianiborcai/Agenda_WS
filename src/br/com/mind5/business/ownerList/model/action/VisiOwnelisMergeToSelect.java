package br.com.mind5.business.ownerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOwnelisMergeToSelect extends ActionVisitorTemplateMerge<OwnelisInfo, OwnelisInfo> {
	
	public VisiOwnelisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OwnelisInfo>> getActionClassHook() {
		return StdOwnelisSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> recordInfos, List<OwnelisInfo> selectedInfos) {	
		return OwnelisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
