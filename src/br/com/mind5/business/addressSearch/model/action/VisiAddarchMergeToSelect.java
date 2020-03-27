package br.com.mind5.business.addressSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.info.AddarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiAddarchMergeToSelect extends ActionVisitorTemplateMerge<AddarchInfo, AddarchInfo> {
	
	public VisiAddarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<AddarchInfo>> getActionClassHook() {
		return StdAddarchSelect.class;
	}
	
	
	
	@Override protected List<AddarchInfo> mergeHook(List<AddarchInfo> baseInfos, List<AddarchInfo> selectedInfos) {	
		return AddarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
