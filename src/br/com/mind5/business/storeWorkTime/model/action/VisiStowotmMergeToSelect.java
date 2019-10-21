package br.com.mind5.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiStowotmMergeToSelect extends ActionVisitorTemplateMergeV2<StowotmInfo, StowotmInfo> {
	
	public VisiStowotmMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StowotmInfo>> getActionClassHook() {
		return StdStowotmSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> mergeHook(List<StowotmInfo> recordInfos, List<StowotmInfo> selectedInfos) {	
		return StowotmMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
