package br.com.gda.business.address.model.checker;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.StdAddressSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AddressCheckLimit extends ModelCheckerTemplateActionV2<AddressInfo, AddressInfo> {
	private final int MAX_RECORD_COUNT = 10;
	
	
	public AddressCheckLimit(ModelCheckerOption option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddressInfo> buildActionHook(DeciTreeOption<AddressInfo> option) {
		ActionStd<AddressInfo> select = new StdAddressSelect(option);
		return select;
	}
	
	
	
	@Override protected int getMaxCountHook() {
		return MAX_RECORD_COUNT;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_LIMIT_NOT_REACHED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_LIMIT_EXCEEDED;
	}
}
