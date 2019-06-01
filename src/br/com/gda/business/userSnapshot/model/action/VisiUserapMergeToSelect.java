package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.info.UserapMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiUserapMergeToSelect extends ActionVisitorTemplateMergeV2<UserapInfo, UserapInfo> {
	
	public VisiUserapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserapInfo>> getActionClassHook() {
		return StdUserapSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> recordInfos, List<UserapInfo> selectedInfos) {	
		return UserapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
