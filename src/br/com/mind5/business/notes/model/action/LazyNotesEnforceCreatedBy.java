package br.com.mind5.business.notes.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyNotesEnforceCreatedBy extends ActionLazyTemplate<NotesInfo, NotesInfo> {
	
	public LazyNotesEnforceCreatedBy(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<NotesInfo> translateRecordInfosHook(List<NotesInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<NotesInfo> getInstanceOfActionHook(DeciTreeOption<NotesInfo> option) {
		return new StdNotesEnforceCreatedBy(option);
	}
	
	
	
	@Override protected DeciResult<NotesInfo> translateResultHook(DeciResult<NotesInfo> result) {
		return result;
	}
}
