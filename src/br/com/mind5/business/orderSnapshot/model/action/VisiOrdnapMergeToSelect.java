package br.com.mind5.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrdnapMergeToSelect extends ActionVisitorTemplateMerge<OrdnapInfo, OrdnapInfo> {
	
	public VisiOrdnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OrdnapInfo>> getActionClassHook() {
		return StdOrdnapSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> recordInfos, List<OrdnapInfo> selectedInfos) {	
		return OrdnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
