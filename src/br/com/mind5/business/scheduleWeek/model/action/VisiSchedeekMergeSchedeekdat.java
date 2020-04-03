package br.com.mind5.business.scheduleWeek.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatCopier;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.decisionTree.RootSchedeekdatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedeekMergeSchedeekdat extends ActionVisitorTemplateMergeV1<SchedeekInfo, SchedeekdatInfo> {
	
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
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
