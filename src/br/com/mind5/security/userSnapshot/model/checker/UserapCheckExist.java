package br.com.mind5.security.userSnapshot.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.action.StdUserapSelect;

public final class UserapCheckExist extends ModelCheckerTemplateAction<UserapInfo, UserapInfo> {
	
	public UserapCheckExist(ModelCheckerOption option) {
		super(option, UserapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<UserapInfo> buildActionHook(DeciTreeOption<UserapInfo> option) {
		ActionStdV1<UserapInfo> select = new StdUserapSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_SNAPSHOT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SNAPSHOT_NOT_FOUND;
	}
}
