package br.com.gda.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.personSearch.info.PerarchInfo;
import br.com.gda.business.personSearch.info.PerarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiPerarchMergeToSelect extends ActionVisitorTemplateMergeV2<PerarchInfo, PerarchInfo> {
	
	public VisiPerarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PerarchInfo>> getActionClassHook() {
		return StdPerarchSelect.class;
	}
	
	
	
	@Override protected List<PerarchInfo> mergeHook(List<PerarchInfo> recordInfos, List<PerarchInfo> selectedInfos) {	
		return PerarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
