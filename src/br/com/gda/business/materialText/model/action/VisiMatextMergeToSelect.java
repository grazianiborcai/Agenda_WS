package br.com.gda.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.info.MatextMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatextMergeToSelect extends ActionVisitorTemplateMergeV2<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextInfo>> getActionClassHook() {
		return StdMatextSelect.class;
	}
	
	
	
	@Override protected List<MatextInfo> toActionClassHook(List<MatextInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> recordInfos, List<MatextInfo> selectedInfos) {	
		return MatextMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
