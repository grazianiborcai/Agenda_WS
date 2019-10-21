package br.com.mind5.business.material.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.info.MatMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatMergeToSelect extends ActionVisitorTemplateMergeV2<MatInfo, MatInfo> {
	
	public VisiMatMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatInfo>> getActionClassHook() {
		return StdMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> mergeHook(List<MatInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return MatMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
