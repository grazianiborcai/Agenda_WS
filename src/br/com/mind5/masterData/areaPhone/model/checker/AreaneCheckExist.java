package br.com.mind5.masterData.areaPhone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.masterData.areaPhone.model.action.AreaneVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AreaneCheckExist extends ModelCheckerTemplateAction<AreaneInfo, AreaneInfo> {
	
	public AreaneCheckExist(ModelCheckerOption option) {
		super(option, AreaneInfo.class);
	}
	
	
	
	@Override protected ActionStd<AreaneInfo> buildActionHook(DeciTreeOption<AreaneInfo> option) {
		ActionStd<AreaneInfo> select = new ActionStdCommom<AreaneInfo>(option, AreaneVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.AREA_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AREA_PHONE_NOT_FOUND;
	}
}
