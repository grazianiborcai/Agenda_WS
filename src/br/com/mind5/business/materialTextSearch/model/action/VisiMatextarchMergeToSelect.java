package br.com.mind5.business.materialTextSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiMatextarchMergeToSelect extends ActionVisitorTemplateMerge<MatextarchInfo, MatextarchInfo> {
	
	public VisiMatextarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<MatextarchInfo>> getActionClassHook() {
		return StdMatextarchSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextarchInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatextarchInfo> mergeHook(List<MatextarchInfo> recordInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
