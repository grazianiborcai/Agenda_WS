package br.com.mind5.payment.payOrder.model.checker;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchCopier;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.CrecarchRootSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordCheckCrecarch extends ModelCheckerTemplateAction<PayordInfo, CrecarchInfo> {
	
	public PayordCheckCrecarch(ModelCheckerOption option) {
		super(option, CrecarchInfo.class);
	}
	

	
	@Override protected ActionStd<CrecarchInfo> buildActionHook(DeciTreeOption<CrecarchInfo> option) {
		ActionStd<CrecarchInfo> select = new CrecarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CrecarchInfo> toActionClassHook(List<PayordInfo> recordInfos) {	
		return CrecarchCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_NOT_FOUND_M);
		builder.addParam01(SystemCode.PAY_ORDER_HEADER);
		builder.addParam02(SystemCode.CREDIT_CARD);

		return builder.build();
	}
}
