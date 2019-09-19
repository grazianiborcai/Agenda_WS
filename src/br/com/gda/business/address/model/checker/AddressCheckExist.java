package br.com.gda.business.address.model.checker;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.StdAddressSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
