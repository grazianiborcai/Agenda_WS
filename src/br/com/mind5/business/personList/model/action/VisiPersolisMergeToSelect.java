package br.com.mind5.business.personList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiPersolisMergeToSelect extends ActionVisitorTemplateMergeV2<PersolisInfo, PersolisInfo> {
	
	public VisiPersolisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PersolisInfo>> getActionClassHook() {
		return StdPersolisSelect.class;
	}
	
	
	
	@Override protected List<PersolisInfo> mergeHook(List<PersolisInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return PersolisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
