package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdNotesMergeToUpdate extends ActionStdTemplate<NotesInfo> {

	public StdNotesMergeToUpdate(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<NotesInfo> buildVisitorHook(DeciTreeOption<NotesInfo> option) {
		return new VisiNotesMergeToUpdate(option);
	}
}
