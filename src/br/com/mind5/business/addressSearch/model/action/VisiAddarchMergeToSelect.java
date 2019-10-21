package br.com.mind5.business.addressSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.info.AddarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiAddarchMergeToSelect extends ActionVisitorTemplateMergeV2<AddarchInfo, AddarchInfo> {
	
	public VisiAddarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<AddarchInfo>> getActionClassHook() {
		return StdAddarchSelect.class;
	}
	
	
	
	@Override protected List<AddarchInfo> mergeHook(List<AddarchInfo> recordInfos, List<AddarchInfo> selectedInfos) {	
		return AddarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
