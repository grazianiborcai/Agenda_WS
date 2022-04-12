package br.com.mind5.business.phoneSnapshot.model.checker;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.action.PhonapVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonapCheckExist extends ModelCheckerTemplateAction<PhonapInfo, PhonapInfo> {
	
	public PhonapCheckExist(ModelCheckerOption option) {
		super(option, PhonapInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonapInfo> buildActionHook(DeciTreeOption<PhonapInfo> option) {
		ActionStd<PhonapInfo> select = new ActionStdCommom<PhonapInfo>(option, PhonapVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_SNAPSHOT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SNAPSHOT_NOT_FOUND;
	}
}
