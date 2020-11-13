package br.com.mind5.business.addressDefault.model.checker;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.decisionTree.RootAddaultSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddaultCheckExist extends ModelCheckerTemplateActionV2<AddaultInfo, AddaultInfo> {
	
	public AddaultCheckExist(ModelCheckerOption option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<AddaultInfo> buildActionHook(DeciTreeOption<AddaultInfo> option) {
		ActionStdV2<AddaultInfo> select = new RootAddaultSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_DEFAULT_NOT_FOUND;
	}
}
