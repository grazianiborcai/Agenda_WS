package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class NotesVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<NotesInfo> {
	
	public NotesVisiEnforceCreatedOn(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected NotesInfo enforceHook(NotesInfo recordInfo) {
		InfoSetter<NotesInfo> attrSetter = new NotesSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
