package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesEnforceCreatedOn extends ActionVisitorTemplateEnforce<NotesInfo> {
	
	public VisiNotesEnforceCreatedOn(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected NotesInfo enforceHook(NotesInfo recordInfo) {
		InfoSetter<NotesInfo> attrSetter = new NotesSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
