package br.com.gda.business.schedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.ScheduMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiScheduMergeToSelect extends ActionVisitorTemplateMergeV2<ScheduInfo, ScheduInfo> {
	
	public VisiScheduMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, ScheduInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<ScheduInfo>> getActionClassHook() {
		return StdScheduSelect.class;
	}
	
	
	
	@Override protected List<ScheduInfo> mergeHook(List<ScheduInfo> recordInfos, List<ScheduInfo> selectedInfos) {	
		return ScheduMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
