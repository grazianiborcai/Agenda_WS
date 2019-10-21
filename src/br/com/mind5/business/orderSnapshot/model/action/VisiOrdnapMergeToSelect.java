package br.com.mind5.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrdnapMergeToSelect extends ActionVisitorTemplateMergeV2<OrdnapInfo, OrdnapInfo> {
	
	public VisiOrdnapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdnapInfo>> getActionClassHook() {
		return StdOrdnapSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> recordInfos, List<OrdnapInfo> selectedInfos) {	
		return OrdnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
