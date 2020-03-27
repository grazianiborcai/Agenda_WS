package br.com.mind5.business.materialTextDefault.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.info.MatextaultMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatextaultMergeToSelect extends ActionVisitorTemplateMerge<MatextaultInfo, MatextaultInfo> {
	
	public VisiMatextaultMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatextaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextaultInfo>> getActionClassHook() {
		return StdMatextaultSelect.class;
	}
	
	
	
	@Override protected List<MatextaultInfo> toActionClassHook(List<MatextaultInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatextaultInfo> mergeHook(List<MatextaultInfo> recordInfos, List<MatextaultInfo> selectedInfos) {	
		return MatextaultMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
