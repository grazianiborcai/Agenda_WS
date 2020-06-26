package br.com.mind5.business.addressSnapshot.model.checker;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.StdAddresnapDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapCheckExist extends ModelCheckerTemplateActionV2<AddresnapInfo, AddresnapInfo>{
	
	public AddresnapCheckExist(ModelCheckerOption option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<AddresnapInfo> buildActionHook(DeciTreeOption<AddresnapInfo> option) {
		ActionStdV1<AddresnapInfo> select = new StdAddresnapDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_SNAP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SNAP_NOT_FOUND;
	}
}
