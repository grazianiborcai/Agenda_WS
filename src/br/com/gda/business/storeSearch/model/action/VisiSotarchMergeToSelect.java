package br.com.gda.business.storeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeSearch.info.SotarchInfo;
import br.com.gda.business.storeSearch.info.SotarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiSotarchMergeToSelect extends ActionVisitorTemplateMergeV2<SotarchInfo, SotarchInfo> {
	
	public VisiSotarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SotarchInfo>> getActionClassHook() {
		return StdSotarchSelect.class;
	}
	
	
	
	@Override protected List<SotarchInfo> mergeHook(List<SotarchInfo> recordInfos, List<SotarchInfo> selectedInfos) {	
		return SotarchMerger.mergeToSelect(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
