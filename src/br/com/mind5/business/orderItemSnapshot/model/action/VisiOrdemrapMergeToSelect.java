package br.com.mind5.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrdemrapMergeToSelect extends ActionVisitorTemplateMerge<OrdemrapInfo, OrdemrapInfo> {
	
	public VisiOrdemrapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdemrapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdemrapInfo>> getActionClassHook() {
		return StdOrdemrapSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> recordInfos, List<OrdemrapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
