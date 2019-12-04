package br.com.mind5.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatextMergeToDelete extends ActionVisitorTemplateMergeV2<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextInfo>> getActionClassHook() {
		return StdMatextSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> recordInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
