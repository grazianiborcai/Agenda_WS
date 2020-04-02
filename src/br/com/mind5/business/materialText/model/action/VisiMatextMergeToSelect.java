package br.com.mind5.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatextMergeToSelect extends ActionVisitorTemplateMerge<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatextInfo>> getActionClassHook() {
		return StdMatextSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatextInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> recordInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
