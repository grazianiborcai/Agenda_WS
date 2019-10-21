package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolisMergeTimezone extends ActionVisitorTemplateMergeV2<StolisInfo, TimezoneInfo> {
	
	public VisiStolisMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> recordInfos, List<TimezoneInfo> selectedInfos) {	
		return StolisMerger.mergeWithTimezone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
