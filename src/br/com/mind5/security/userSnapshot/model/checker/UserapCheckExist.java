package br.com.mind5.security.userSnapshot.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.action.StdUserapSelect;

public final class UserapCheckExist extends ModelCheckerTemplateActionV2<UserapInfo, UserapInfo> {
	
	public UserapCheckExist(ModelCheckerOption option) {
		super(option, UserapInfo.class);
	}
	
	
	
	@Override protected ActionStd<UserapInfo> buildActionHook(DeciTreeOption<UserapInfo> option) {
		ActionStd<UserapInfo> select = new StdUserapSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_SNAPSHOT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_SNAPSHOT_NOT_FOUND;
	}
}
