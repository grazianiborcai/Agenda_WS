package br.com.mind5.message.sysMessage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiSymsgMergeToSelect extends ActionVisitorTemplateMerge<SymsgInfo, SymsgInfo> {
	
	public VisiSymsgMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SymsgInfo>> getActionClassHook() {
		return StdSymsgSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> mergeHook(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return SymsgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
