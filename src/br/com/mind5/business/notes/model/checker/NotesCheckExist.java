package br.com.mind5.business.notes.model.checker;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.StdNotesDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class NotesCheckExist extends ModelCheckerTemplateActionV2<NotesInfo, NotesInfo> {	
	
	public NotesCheckExist(ModelCheckerOption option) {
		super(option, NotesInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<NotesInfo> buildActionHook(DeciTreeOption<NotesInfo> option) {
		ActionStdV2<NotesInfo> select = new StdNotesDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.NOTES_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.NOTES_NOT_FOUND;
	}
}
