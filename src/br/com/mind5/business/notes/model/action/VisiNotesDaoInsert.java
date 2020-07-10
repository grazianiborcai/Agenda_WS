package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.dao.DaoNotesInsert;
import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesDaoInsert extends ActionVisitorTemplateStmtV2<NotesInfo> {

	public VisiNotesDaoInsert(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<NotesInfo> buildStmtExecHook(List<DaoStmtExecOption<NotesInfo>> stmtOptions) {
		return new DaoNotesInsert(stmtOptions);
	}
}
