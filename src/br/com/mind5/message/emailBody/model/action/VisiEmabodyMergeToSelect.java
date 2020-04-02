package br.com.mind5.message.emailBody.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.info.EmabodyMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmabodyMergeToSelect extends ActionVisitorTemplateMerge<EmabodyInfo, EmabodyInfo> {
	
	public VisiEmabodyMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmabodyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmabodyInfo>> getActionClassHook() {
		return StdEmabodySelect.class;
	}
	
	
	
	@Override protected List<EmabodyInfo> mergeHook(List<EmabodyInfo> recordInfos, List<EmabodyInfo> selectedInfos) {	
		return EmabodyMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
