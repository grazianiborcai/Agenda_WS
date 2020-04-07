package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree.RootPeresmoipSelect;

public final class PeresmoipCheckExist extends ModelCheckerTemplateActionV2<PeresmoipInfo, PeresmoipInfo> {
	
	public PeresmoipCheckExist(ModelCheckerOption option) {
		super(option, PeresmoipInfo.class);
	}
	

	
	@Override protected ActionStdV1<PeresmoipInfo> buildActionHook(DeciTreeOption<PeresmoipInfo> option) {
		ActionStdV1<PeresmoipInfo> select = new RootPeresmoipSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MOIP_PERM_RESP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOIP_PERM_RESP_NOT_FOUND;
	}
}
