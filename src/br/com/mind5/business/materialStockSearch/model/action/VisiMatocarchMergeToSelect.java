package br.com.mind5.business.materialStockSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.business.materialStockSearch.info.MatocarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatocarchMergeToSelect extends ActionVisitorTemplateMerge<MatocarchInfo, MatocarchInfo> {
	
	public VisiMatocarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatocarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatocarchInfo>> getActionClassHook() {
		return StdMatocarchSelect.class;
	}
	
	
	
	@Override protected List<MatocarchInfo> mergeHook(List<MatocarchInfo> recordInfos, List<MatocarchInfo> selectedInfos) {	
		return MatocarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
