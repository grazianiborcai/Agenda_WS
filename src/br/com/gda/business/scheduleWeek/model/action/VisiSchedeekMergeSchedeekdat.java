package br.com.gda.business.scheduleWeek.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.business.scheduleWeek.info.SchedeekMerger;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatCopier;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.business.scheduleWeekData.model.decisionTree.RootSchedeekdatSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedeekMergeSchedeekdat extends ActionVisitorTemplateMergeV2<SchedeekInfo, SchedeekdatInfo> {
	
	public VisiSchedeekMergeSchedeekdat(Connection conn, String schemaName) {
		super(conn, schemaName, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedeekdatInfo>> getTreeClassHook() {
		return RootSchedeekdatSelect.class;
	}
	
	
	
	@Override protected List<SchedeekdatInfo> toActionClassHook(List<SchedeekInfo> recordInfos) {
		return SchedeekdatCopier.copyFromSchedeek(recordInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> recordInfos, List<SchedeekdatInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithSchedeekdat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
