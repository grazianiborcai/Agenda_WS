package br.com.mind5.masterData.movimentType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.action.StdMamovypeDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MamovypeCheckExist extends ModelCheckerTemplateAction<MamovypeInfo, MamovypeInfo> {
	
	public MamovypeCheckExist(ModelCheckerOption option) {
		super(option, MamovypeInfo.class);
	}
	
	
	
	@Override protected ActionStd<MamovypeInfo> buildActionHook(DeciTreeOption<MamovypeInfo> option) {
		ActionStd<MamovypeInfo> select = new StdMamovypeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_MOV_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_TYPE_NOT_FOUND;
	}
}
