package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposSelect;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckSoftDelete extends ModelCheckerTemplateAction<EmposInfo, EmposInfo> {
	
	public EmposCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmposInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmposInfo> buildActionHook(DeciTreeOption<EmposInfo> option) {
		ActionStdV1<EmposInfo> enforceDel = new StdEmposEnforceDel(option);
		ActionLazyV1<EmposInfo> select = new LazyEmposSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);		
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_FLAGGED_AS_DELETED;
	}
}
