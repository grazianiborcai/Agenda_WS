package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiStolisMergeToSelect extends ActionVisitorTemplateMergeV2<StolisInfo, StolisInfo> {
	
	public VisiStolisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolisInfo>> getActionClassHook() {
		return StdStolisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return StolisMerger.mergeToSelect(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
