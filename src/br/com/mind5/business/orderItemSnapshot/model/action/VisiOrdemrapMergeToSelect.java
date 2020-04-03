package br.com.mind5.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiOrdemrapMergeToSelect extends ActionVisitorTemplateMergeV1<OrdemrapInfo, OrdemrapInfo> {
	
	public VisiOrdemrapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdemrapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OrdemrapInfo>> getActionClassHook() {
		return StdOrdemrapSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> recordInfos, List<OrdemrapInfo> selectedInfos) {	
		return OrdemrapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
