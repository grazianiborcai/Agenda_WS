package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStorapMergeTimezone extends ActionVisitorTemplateMergeV2<StorapInfo, TimezoneInfo> {
	
	public VisiStorapMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<TimezoneInfo> selectedInfos) {	
		return StorapMerger.mergeWithTimezone(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
