package br.com.mind5.config.payPartnerCustomerCreation.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreInfo;
import br.com.mind5.config.payPartnerStoreCreation.model.decisionTree.PayrsocreRootSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrcucreCheckExist extends ModelCheckerTemplateAction<PayrsocreInfo, PayrsocreInfo> {
	
	public PayrcucreCheckExist(ModelCheckerOption option) {
		super(option, PayrsocreInfo.class);
	}
	

	
	@Override protected ActionStd<PayrsocreInfo> buildActionHook(DeciTreeOption<PayrsocreInfo> option) {
		ActionStd<PayrsocreInfo> select = new PayrsocreRootSelect(option).toAction();
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
