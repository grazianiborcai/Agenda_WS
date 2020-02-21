package br.com.mind5.payment.creditCardSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchMerger;

final class VisiCrecarchMergeToSelect extends ActionVisitorTemplateMergeV2<CrecarchInfo, CrecarchInfo> {
	
	public VisiCrecarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CrecarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CrecarchInfo>> getActionClassHook() {
		return StdCrecarchSelect.class;
	}
	
	
	
	@Override protected List<CrecarchInfo> mergeHook(List<CrecarchInfo> baseInfos, List<CrecarchInfo> selectedInfos) {	
		return CrecarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}