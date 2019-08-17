package br.com.gda.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedinapMergeStolis extends ActionVisitorTemplateMergeV2<SchedinapInfo, StolisInfo> {
	
	public VisiSchedinapMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
