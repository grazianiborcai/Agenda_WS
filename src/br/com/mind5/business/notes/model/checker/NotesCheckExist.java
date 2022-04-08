package br.com.mind5.business.notes.model.checker;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.NotesVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class NotesCheckExist extends ModelCheckerTemplateAction<NotesInfo, NotesInfo> {	
	
	public NotesCheckExist(ModelCheckerOption option) {
		super(option, NotesInfo.class);
	}
	
	
	
	@Override protected ActionStd<NotesInfo> buildActionHook(DeciTreeOption<NotesInfo> option) {
		ActionStd<NotesInfo> select = new ActionStdCommom<NotesInfo>(option, NotesVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.NOTES_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.NOTES_NOT_FOUND;
	}
}
