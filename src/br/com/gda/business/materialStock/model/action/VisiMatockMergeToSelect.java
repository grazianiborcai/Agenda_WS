package br.com.gda.business.materialStock.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.info.MatockMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatockMergeToSelect extends ActionVisitorTemplateMergeV2<MatockInfo, MatockInfo> {
	
	public VisiMatockMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatockInfo>> getActionClassHook() {
		return StdMatockSelect.class;
	}
	
	
	
	@Override protected List<MatockInfo> mergeHook(List<MatockInfo> recordInfos, List<MatockInfo> selectedInfos) {	
		return MatockMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
