package br.com.mind5.business.employeePosition.model.checker;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePositionSearch.info.EmposarchCopier;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.decisionTree.RootEmposarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckEmposarch extends ModelCheckerTemplateActionV2<EmposInfo, EmposarchInfo> {
	
	public EmposCheckEmposarch(ModelCheckerOption option) {
		super(option, EmposarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmposarchInfo> buildActionHook(DeciTreeOption<EmposarchInfo> option) {
		ActionStd<EmposarchInfo> select = new RootEmposarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<EmposarchInfo> toActionClassHook(List<EmposInfo> recordInfos) {
		return EmposarchCopier.copyFromEmpos(recordInfos);
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMPOS_HAS_ITEM;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMPOS_NO_ITEM_FOUND;
	}
}
