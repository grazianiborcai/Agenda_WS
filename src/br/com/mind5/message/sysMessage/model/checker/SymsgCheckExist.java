package br.com.mind5.message.sysMessage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.StdSymsgSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SymsgCheckExist extends ModelCheckerTemplateActionV2<SymsgInfo, SymsgInfo> {
	
	public SymsgCheckExist(ModelCheckerOption option) {
		super(option, SymsgInfo.class);
	}
	
	
	
	@Override protected ActionStd<SymsgInfo> buildActionHook(DeciTreeOption<SymsgInfo> option) {
		ActionStd<SymsgInfo> select = new StdSymsgSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_MESSAGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_MESSAGE_NOT_FOUND;
	}
}
