package br.com.mind5.masterData.areaPhone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.masterData.areaPhone.model.action.StdAreaneDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AreaneCheckExist extends ModelCheckerTemplateActionV2<AreaneInfo, AreaneInfo> {
	
	public AreaneCheckExist(ModelCheckerOption option) {
		super(option, AreaneInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<AreaneInfo> buildActionHook(DeciTreeOption<AreaneInfo> option) {
		ActionStdV1<AreaneInfo> select = new StdAreaneDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.AREA_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AREA_PHONE_NOT_FOUND;
	}
}
