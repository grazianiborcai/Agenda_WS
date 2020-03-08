package br.com.mind5.security.userSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergeToSelect extends ActionVisitorTemplateMergeV2<UserapInfo, UserapInfo> {
	
	public VisiUserapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserapInfo>> getActionClassHook() {
		return StdUserapSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<UserapInfo> selectedInfos) {	
		return UserapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
