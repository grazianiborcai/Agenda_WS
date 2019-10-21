package br.com.mind5.business.scheduleWeekData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedeekdatMergeToSelect extends ActionVisitorTemplateMergeV2<SchedeekdatInfo, SchedeekdatInfo> {
	
	public VisiSchedeekdatMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedeekdatInfo>> getActionClassHook() {
		return StdSchedeekdatSelect.class;
	}
	
	
	
	@Override protected List<SchedeekdatInfo> mergeHook(List<SchedeekdatInfo> recordInfos, List<SchedeekdatInfo> selectedInfos) {	
		return SchedeekdatMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
