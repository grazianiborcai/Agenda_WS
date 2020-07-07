package br.com.mind5.business.notes.model.action;

import java.util.List;

import br.com.mind5.business.notes.dao.DaoNotesSelect;
import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesDaoSelect extends ActionVisitorTemplateStmtV2<NotesInfo>{

	public VisiNotesDaoSelect(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<NotesInfo> buildStmtExecHook(List<DaoStmtExecOption<NotesInfo>> stmtOptions) {
		return new DaoNotesSelect(stmtOptions);
	}
}
