package br.com.mind5.business.notes.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyNotesEnforceLChanged extends ActionLazyTemplateV2<NotesInfo, NotesInfo> {
	
	public LazyNotesEnforceLChanged(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<NotesInfo> translateRecordInfosHook(List<NotesInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<NotesInfo> getInstanceOfActionHook(DeciTreeOption<NotesInfo> option) {
		return new StdNotesEnforceLChanged(option);
	}
	
	
	
	@Override protected DeciResult<NotesInfo> translateResultHook(DeciResult<NotesInfo> result) {
		return result;
	}
}
