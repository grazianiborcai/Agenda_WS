package br.com.gda.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrdemrapMergeToSelect extends ActionVisitorTemplateMergeV2<OrdemrapInfo, OrdemrapInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
