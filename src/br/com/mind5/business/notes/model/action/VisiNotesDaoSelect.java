package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.dao.DaoNotesSelect;
import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesDaoSelect extends ActionVisitorTemplateStmt<NotesInfo> {

	public VisiNotesDaoSelect(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<NotesInfo> buildStmtExecHook(List<DaoStmtExecOption<NotesInfo>> stmtOptions) {
		return new DaoNotesSelect(stmtOptions);
	}
}
