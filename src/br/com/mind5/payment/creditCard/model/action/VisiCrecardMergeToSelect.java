package br.com.mind5.payment.creditCard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

final class VisiCrecardMergeToSelect extends ActionVisitorTemplateMergeV2<CrecardInfo, CrecardInfo> {
	
	public VisiCrecardMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CrecardInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CrecardInfo>> getActionClassHook() {
		return StdCrecardSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> recordInfos, List<CrecardInfo> selectedInfos) {	
		return CrecardMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
