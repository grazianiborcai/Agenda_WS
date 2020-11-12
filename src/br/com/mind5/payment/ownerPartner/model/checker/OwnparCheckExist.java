package br.com.mind5.payment.ownerPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.StdOwnparDaoSelect;

public final class OwnparCheckExist extends ModelCheckerTemplateActionV2<OwnparInfo, OwnparInfo> {
	
	public OwnparCheckExist(ModelCheckerOption option) {
		super(option, OwnparInfo.class);
	}
	

	
	@Override protected ActionStdV1<OwnparInfo> buildActionHook(DeciTreeOption<OwnparInfo> option) {
		ActionStdV1<OwnparInfo> select = new StdOwnparDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_OWNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_OWNER_NOT_FOUND;
	}
}
