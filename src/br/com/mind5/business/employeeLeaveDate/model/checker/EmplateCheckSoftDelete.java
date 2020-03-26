package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateCheckSoftDelete extends ModelCheckerTemplateAction<EmplateInfo, EmplateInfo> {	
	
	public EmplateCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> buildActionHook(DeciTreeOption<EmplateInfo> option) {
		ActionStd<EmplateInfo> enforceDel = new StdEmplateEnforceDel(option);
		ActionLazy<EmplateInfo> select = new LazyEmplateSelect(option.conn, option.schemaName);		
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_FLAGGED_AS_DELETED;
	}	
}
