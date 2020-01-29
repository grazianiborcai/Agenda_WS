package br.com.mind5.business.ownerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.info.OwnelisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiOwnelisMergeToSelect extends ActionVisitorTemplateMergeV2<OwnelisInfo, OwnelisInfo> {
	
	public VisiOwnelisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnelisInfo>> getActionClassHook() {
		return StdOwnelisSelect.class;
	}
	
	
	
	@Override protected List<OwnelisInfo> mergeHook(List<OwnelisInfo> recordInfos, List<OwnelisInfo> selectedInfos) {	
		return OwnelisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
