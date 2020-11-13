package br.com.mind5.business.orderSnapshot.model.checker;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.action.StdOrdnapDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdnapCheckExist extends ModelCheckerTemplateAction<OrdnapInfo, OrdnapInfo> {
	
	public OrdnapCheckExist(ModelCheckerOption option) {
		super(option, OrdnapInfo.class);
	}
	

	
	@Override protected ActionStd<OrdnapInfo> buildActionHook(DeciTreeOption<OrdnapInfo> option) {
		ActionStd<OrdnapInfo> select = new StdOrdnapDaoSelect(option);		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_HEADER_SNAP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_HEADER_SNAP_NOT_FOUND;
	}
}
