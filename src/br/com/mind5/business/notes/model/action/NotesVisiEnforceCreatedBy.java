package br.com.mind5.business.notes.model.action;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.info.NotesSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class NotesVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<NotesInfo> {
	
	public NotesVisiEnforceCreatedBy(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected NotesInfo enforceHook(NotesInfo recordInfo) {
		InfoSetter<NotesInfo> attrSetter = new NotesSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
