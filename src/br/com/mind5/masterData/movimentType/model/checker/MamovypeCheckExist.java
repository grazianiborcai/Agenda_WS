package br.com.mind5.masterData.movimentType.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.action.StdMamovypeDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MamovypeCheckExist extends ModelCheckerTemplateActionV2<MamovypeInfo, MamovypeInfo> {
	
	public MamovypeCheckExist(ModelCheckerOption option) {
		super(option, MamovypeInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MamovypeInfo> buildActionHook(DeciTreeOption<MamovypeInfo> option) {
		ActionStdV1<MamovypeInfo> select = new StdMamovypeDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_MOV_TYPE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_MOV_TYPE_NOT_FOUND;
	}
}
