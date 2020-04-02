package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchMerger;

final class VisiCusparchMergeToSelect extends ActionVisitorTemplateMerge<CusparchInfo, CusparchInfo> {
	
	public VisiCusparchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CusparchInfo>> getActionClassHook() {
		return StdCusparchSelect.class;
	}
	
	
	
	@Override protected List<CusparchInfo> mergeHook(List<CusparchInfo> baseInfos, List<CusparchInfo> selectedInfos) {	
		return CusparchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
