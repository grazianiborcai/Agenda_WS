package br.com.mind5.business.employeeLunchTime.model.checker;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class EmplutmCheckExist extends ModelCheckerTemplateAction<EmplutmInfo, EmplutmInfo> {
	
	public EmplutmCheckExist(ModelCheckerOption option) {
		super(option, EmplutmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplutmInfo> buildActionHook(DeciTreeOption<EmplutmInfo> option) {
		ActionStd<EmplutmInfo> select = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiDaoSelect.class);
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LTIME_ALREADY_EXIST;	
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_LTIME_NOT_FOUND;	
	}
}
