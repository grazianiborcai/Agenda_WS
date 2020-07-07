package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdNotesSuccess extends ActionStdSuccessTemplate<NotesInfo> {
	public StdNotesSuccess(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
}
