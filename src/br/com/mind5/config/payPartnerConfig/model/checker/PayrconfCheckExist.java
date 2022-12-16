package br.com.mind5.config.payPartnerConfig.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.action.PayrconfVisiDaoSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrconfCheckExist extends ModelCheckerTemplateAction<PayrconfInfo, PayrconfInfo> {
	
	public PayrconfCheckExist(ModelCheckerOption option) {
		super(option, PayrconfInfo.class);
	}
	

	
	@Override protected ActionStd<PayrconfInfo> buildActionHook(DeciTreeOption<PayrconfInfo> option) {
		ActionStd<PayrconfInfo> select = new ActionStdCommom<PayrconfInfo>(option, PayrconfVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_M);
		builder.addParam01(SystemCode.PAY_PARTNER_CONFIG);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_M);
		builder.addParam01(SystemCode.PAY_PARTNER_CONFIG);

		return builder.build();
	}
}
