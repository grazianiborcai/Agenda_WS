package br.com.mind5.business.employeePosition.model.checker;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposSelect;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceEmpKey_;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckHasEmpItem_ extends ModelCheckerTemplateActionV2<EmposInfo, EmposInfo> {	
	
	public EmposCheckHasEmpItem_(ModelCheckerOption option) {
		super(option, EmposInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmposInfo> buildActionHook(DeciTreeOption<EmposInfo> option) {
		ActionStd<EmposInfo> select = new StdEmposEnforceEmpKey_(option);
		select.addPostAction(new LazyEmposSelect(option.conn, option.schemaName));
		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_HAS_ITEM;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NO_ITEM_FOUND;
	}
}
