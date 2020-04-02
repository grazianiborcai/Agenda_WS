package br.com.mind5.business.personList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiPersolisMergeToSelect extends ActionVisitorTemplateMerge<PersolisInfo, PersolisInfo> {
	
	public VisiPersolisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PersolisInfo>> getActionClassHook() {
		return StdPersolisSelect.class;
	}
	
	
	
	@Override protected List<PersolisInfo> mergeHook(List<PersolisInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return PersolisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
