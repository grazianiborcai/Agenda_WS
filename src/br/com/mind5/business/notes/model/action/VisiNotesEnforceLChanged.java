package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiNotesEnforceLChanged extends ActionVisitorTemplateEnforceV2<NotesInfo> {
	
	public VisiNotesEnforceLChanged(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected NotesInfo enforceHook(NotesInfo recordInfo) {
		InfoSetter<NotesInfo> attrSetter = new NotesSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
