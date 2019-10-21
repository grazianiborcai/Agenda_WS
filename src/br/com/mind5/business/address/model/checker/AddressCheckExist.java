package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.StdAddressSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressCheckExist extends ModelCheckerTemplateActionV2<AddressInfo, AddressInfo> {
	
	public AddressCheckExist(ModelCheckerOption option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddressInfo> buildActionHook(DeciTreeOption<AddressInfo> option) {
		ActionStd<AddressInfo> actionSelect = new StdAddressSelect(option);
		return actionSelect;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_NOT_FOUND;
	}
}
