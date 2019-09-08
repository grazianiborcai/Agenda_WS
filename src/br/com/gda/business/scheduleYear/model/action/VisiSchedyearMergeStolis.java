package br.com.gda.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.business.scheduleYear.info.SchedyearMerger;
import br.com.gda.business.storeList.info.StolisCopier;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedyearMergeStolis extends ActionVisitorTemplateMergeV2<SchedyearInfo, StolisInfo> {
	
	public VisiSchedyearMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> toActionClassHook(List<SchedyearInfo> recordInfos) {
		return StolisCopier.copyFromSchedyear(recordInfos);
	}
	
	
	
	@Override protected List<SchedyearInfo> mergeHook(List<SchedyearInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return SchedyearMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
