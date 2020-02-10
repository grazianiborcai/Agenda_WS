package br.com.mind5.business.addressSnapshot.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapCheckExist extends ModelCheckerTemplateActionV2<AddresnapInfo, AddresnapInfo> {
	
	public AddresnapCheckExist(ModelCheckerOption option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddresnapInfo> buildActionHook(DeciTreeOption<AddresnapInfo> option) {
		ActionStd<AddresnapInfo> select = new StdAddresnapSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_SNAP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SNAP_NOT_FOUND;
	}
}
