package br.com.mind5.message.sysMessage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiSymsgMergeToSelect extends ActionVisitorTemplateMergeV1<SymsgInfo, SymsgInfo> {
	
	public VisiSymsgMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<SymsgInfo>> getActionClassHook() {
		return StdSymsgSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> mergeHook(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return SymsgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
