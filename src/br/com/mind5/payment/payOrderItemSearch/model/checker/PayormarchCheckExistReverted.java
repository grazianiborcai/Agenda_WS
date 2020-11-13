package br.com.mind5.payment.payOrderItemSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.action.LazyPayormarchRootSelect;
import br.com.mind5.payment.payOrderItemSearch.model.action.StdPayormarchEnforceReverted;

public final class PayormarchCheckExistReverted extends ModelCheckerTemplateActionV2<PayormarchInfo, PayormarchInfo> {
	
	public PayormarchCheckExistReverted(ModelCheckerOption option) {
		super(option, PayormarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<PayormarchInfo> buildActionHook(DeciTreeOption<PayormarchInfo> option) {
		ActionStdV1<PayormarchInfo> enforceReverted = new StdPayormarchEnforceReverted(option);
		ActionLazy<PayormarchInfo> select = new LazyPayormarchRootSelect(option.conn, option.schemaName);
		
		enforceReverted.addPostAction(select);
		
		return enforceReverted;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_ORDER_ITEM_SEARCH_NOT_FOUND;
	}
}
