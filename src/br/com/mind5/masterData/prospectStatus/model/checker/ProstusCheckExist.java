package br.com.mind5.masterData.prospectStatus.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.masterData.prospectStatus.model.action.StdProstusDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ProstusCheckExist extends ModelCheckerTemplateActionV2<ProstusInfo, ProstusInfo> {
	
	public ProstusCheckExist(ModelCheckerOption option) {
		super(option, ProstusInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<ProstusInfo> buildActionHook(DeciTreeOption<ProstusInfo> option) {
		ActionStdV2<ProstusInfo> select = new StdProstusDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PROSP_STATUS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PROSP_STATUS_NOT_FOUND;
	}
}
