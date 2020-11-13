package br.com.mind5.masterData.prospectStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.masterData.prospectStatus.model.action.StdProstusDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ProstusCheckExist extends ModelCheckerTemplateAction<ProstusInfo, ProstusInfo> {
	
	public ProstusCheckExist(ModelCheckerOption option) {
		super(option, ProstusInfo.class);
	}
	
	
	
	@Override protected ActionStd<ProstusInfo> buildActionHook(DeciTreeOption<ProstusInfo> option) {
		ActionStd<ProstusInfo> select = new StdProstusDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PROSP_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PROSP_STATUS_NOT_FOUND;
	}
}
