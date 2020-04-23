package br.com.mind5.business.employeeLeaveDate.model.checker;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateDaoSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateCheckSoftDelete extends ModelCheckerTemplateActionV2<EmplateInfo, EmplateInfo> {	
	
	public EmplateCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmplateInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmplateInfo> buildActionHook(DeciTreeOption<EmplateInfo> option) {
		ActionStdV1<EmplateInfo> enforceDel = new StdEmplateEnforceDel(option);
		ActionLazyV1<EmplateInfo> select = new LazyEmplateDaoSelect(option.conn, option.schemaName);		
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_LDATE_FLAGGED_AS_DELETED;
	}	
}
