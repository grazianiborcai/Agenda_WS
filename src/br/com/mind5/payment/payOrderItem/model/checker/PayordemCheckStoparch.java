package br.com.mind5.payment.payOrderItem.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.StoparchRootSelectStore;

public final class PayordemCheckStoparch extends ModelCheckerTemplateAction<PayordemInfo, StoparchInfo> {
	
	public PayordemCheckStoparch(ModelCheckerOption option) {
		super(option, StoparchInfo.class);
	}
	

	
	@Override protected ActionStd<StoparchInfo> buildActionHook(DeciTreeOption<StoparchInfo> option) {
		ActionStd<StoparchInfo> select = new StoparchRootSelectStore(option).toAction();
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2);
		builder.addParam01(SystemCode.PAY_ORDER);
		builder.addParam02(SystemCode.PAY_ORDER_STORE_IS_NOT_PAYPARTNER);

		return builder.build();
	}
}
