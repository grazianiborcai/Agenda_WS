package br.com.mind5.config.payPartnerCustomerCreation.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.model.decisionTree.PayrcucreRootSelectEnabled;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrcucreCheckEnabled extends ModelCheckerTemplateAction<PayrcucreInfo, PayrcucreInfo> {
	
	public PayrcucreCheckEnabled(ModelCheckerOption option) {
		super(option, PayrcucreInfo.class);
	}
	

	
	@Override protected ActionStd<PayrcucreInfo> buildActionHook(DeciTreeOption<PayrcucreInfo> option) {
		ActionStd<PayrcucreInfo> select = new PayrcucreRootSelectEnabled(option).toAction();
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_M);
		builder.addParam01(SystemCode.PAY_PARTNER_CONFIG_CUSTOMER_CREATION);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_M);
		builder.addParam01(SystemCode.PAY_PARTNER_CONFIG_CUSTOMER_CREATION);

		return builder.build();
	}
}
