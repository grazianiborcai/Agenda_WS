package br.com.mind5.business.materialSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatarchMergeToSelect extends ActionVisitorTemplateMerge<MatarchInfo, MatarchInfo> {
	
	public VisiMatarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatarchInfo>> getActionClassHook() {
		return StdMatarchSelect.class;
	}
	
	
	
	@Override protected List<MatarchInfo> mergeHook(List<MatarchInfo> baseInfos, List<MatarchInfo> selectedInfos) {	
		return MatarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
