package br.com.mind5.business.materialTextSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiMatextarchMergeToSelect extends ActionVisitorTemplateMergeV2<MatextarchInfo, MatextarchInfo> {
	
	public VisiMatextarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatextarchInfo>> getActionClassHook() {
		return StdMatextarchSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextarchInfo> recordInfos) {
		return recordInfos;	
	}	
	
	
	
	@Override protected List<MatextarchInfo> mergeHook(List<MatextarchInfo> recordInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
