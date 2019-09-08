package br.com.gda.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleMonth.info.SchedmonMerger;
import br.com.gda.business.storeList.info.StolisCopier;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedmonMergeStolis extends ActionVisitorTemplateMergeV2<SchedmonInfo, StolisInfo> {
	
	public VisiSchedmonMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return StolisCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
