package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.StdAddressSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
//TODO: isso esta funcionando ?
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
