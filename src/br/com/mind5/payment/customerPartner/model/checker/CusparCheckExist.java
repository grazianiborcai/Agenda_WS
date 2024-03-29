package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.CusparVisiDaoSelect;

public final class CusparCheckExist extends ModelCheckerTemplateAction<CusparInfo, CusparInfo> {
	
	public CusparCheckExist(ModelCheckerOption option) {
		super(option, CusparInfo.class);
	}
	

	
	@Override protected ActionStd<CusparInfo> buildActionHook(DeciTreeOption<CusparInfo> option) {
		ActionStd<CusparInfo> select = new ActionStdCommom<CusparInfo>(option, CusparVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_CUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_NOT_FOUND;
	}
}
