package br.com.mind5.payment.setupPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.action.StdSetuparDaoSelect;

public final class SetuparCheckExist extends ModelCheckerTemplateActionV2<SetuparInfo, SetuparInfo> {
	
	public SetuparCheckExist(ModelCheckerOption option) {
		super(option, SetuparInfo.class);
	}
	

	
	@Override protected ActionStdV2<SetuparInfo> buildActionHook(DeciTreeOption<SetuparInfo> option) {
		ActionStdV2<SetuparInfo> select = new StdSetuparDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_SETUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_SETUP_NOT_FOUND;
	}
}
