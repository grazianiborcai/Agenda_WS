package br.com.mind5.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiStowotmMergeToSelect extends ActionVisitorTemplateMerge<StowotmInfo, StowotmInfo> {
	
	public VisiStowotmMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<StowotmInfo>> getActionClassHook() {
		return StdStowotmSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> mergeHook(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {	
		return StowotmMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
