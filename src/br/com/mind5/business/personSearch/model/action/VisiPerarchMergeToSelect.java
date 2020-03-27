package br.com.mind5.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiPerarchMergeToSelect extends ActionVisitorTemplateMerge<PerarchInfo, PerarchInfo> {
	
	public VisiPerarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PerarchInfo>> getActionClassHook() {
		return StdPerarchSelect.class;
	}
	
	
	
	@Override protected List<PerarchInfo> mergeHook(List<PerarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {	
		return PerarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
