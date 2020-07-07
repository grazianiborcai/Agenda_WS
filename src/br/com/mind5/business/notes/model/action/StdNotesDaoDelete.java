package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdNotesDaoDelete extends ActionStdTemplateV2<NotesInfo> {

	public StdNotesDaoDelete(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<NotesInfo> buildVisitorHook(DeciTreeOption<NotesInfo> option) {
		return new VisiNotesDaoDelete(option);
	}
}
