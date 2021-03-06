package br.com.mind5.business.notes.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.decisionTree.RootNotesSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyNotesRootSelect extends ActionLazyTemplate<NotesInfo, NotesInfo> {

	public LazyNotesRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<NotesInfo> translateRecordInfosHook(List<NotesInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<NotesInfo> getInstanceOfActionHook(DeciTreeOption<NotesInfo> option) {
		return new RootNotesSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<NotesInfo> translateResultHook(DeciResult<NotesInfo> result) {
		return result;
	}
}
