package br.com.mind5.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiPerarchMergeToSelect extends ActionVisitorTemplateMergeV1<PerarchInfo, PerarchInfo> {
	
	public VisiPerarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<PerarchInfo>> getActionClassHook() {
		return StdPerarchSelect.class;
	}
	
	
	
	@Override protected List<PerarchInfo> mergeHook(List<PerarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {	
		return PerarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
