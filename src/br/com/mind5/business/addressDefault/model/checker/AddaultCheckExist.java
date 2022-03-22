package br.com.mind5.business.addressDefault.model.checker;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.decisionTree.AddaultRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultCheckExist extends ModelCheckerTemplateAction<AddaultInfo, AddaultInfo> {
	
	public AddaultCheckExist(ModelCheckerOption option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddaultInfo> buildActionHook(DeciTreeOption<AddaultInfo> option) {
		ActionStd<AddaultInfo> select = new AddaultRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_DEFAULT_NOT_FOUND;
	}
}
