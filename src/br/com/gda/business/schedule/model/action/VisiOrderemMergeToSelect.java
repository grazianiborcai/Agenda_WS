package br.com.gda.business.schedule.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.info.OrderemMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrderemMergeToSelect extends ActionVisitorTemplateMergeV2<ScheduInfo, ScheduInfo> {
	
	public VisiOrderemMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, ScheduInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<ScheduInfo>> getActionClassHook() {
		return StdOrderemSelect.class;
	}
	
	
	
	@Override protected List<ScheduInfo> mergeHook(List<ScheduInfo> recordInfos, List<ScheduInfo> selectedInfos) {	
		return OrderemMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
