package br.com.mind5.business.storeProspect.model.checker;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.StdStoprosDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosCheckExist extends ModelCheckerTemplateActionV2<StoprosInfo, StoprosInfo> {
	
	public StoprosCheckExist(ModelCheckerOption option) {
		super(option, StoprosInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StoprosInfo> buildActionHook(DeciTreeOption<StoprosInfo> option) {
		ActionStdV1<StoprosInfo> select = new StdStoprosDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_PROSPECT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_PROSPECT_NOT_FOUND;
	}
}
