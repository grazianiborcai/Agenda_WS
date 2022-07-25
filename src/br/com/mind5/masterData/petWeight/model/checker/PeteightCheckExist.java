package br.com.mind5.masterData.petWeight.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.masterData.petWeight.model.action.PeteightVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeteightCheckExist extends ModelCheckerTemplateAction<PeteightInfo, PeteightInfo> {
	
	public PeteightCheckExist(ModelCheckerOption option) {
		super(option, PeteightInfo.class);
	}
	
	
	
	@Override protected ActionStd<PeteightInfo> buildActionHook(DeciTreeOption<PeteightInfo> option) {
		ActionStd<PeteightInfo> select = new ActionStdCommom<PeteightInfo>(option, PeteightVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PET_WEIGHT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_WEIGHT_NOT_FOUND;
	}
}
