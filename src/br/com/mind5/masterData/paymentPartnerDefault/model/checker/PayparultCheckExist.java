package br.com.mind5.masterData.paymentPartnerDefault.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.masterData.paymentPartnerDefault.model.action.PayparultVisiDaoSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayparultCheckExist extends ModelCheckerTemplateAction<PayparultInfo, PayparultInfo> {
	
	public PayparultCheckExist(ModelCheckerOption option) {
		super(option, PayparultInfo.class);
	}
	
	
	
	@Override protected ActionStd<PayparultInfo> buildActionHook(DeciTreeOption<PayparultInfo> option) {
		ActionStd<PayparultInfo> select = new ActionStdCommom<PayparultInfo>(option, PayparultVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_M);
		builder.addParam01(SystemCode.PAY_PARTNER_DEFAULT);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_M);
		builder.addParam01(SystemCode.PAY_PARTNER_DEFAULT);

		return builder.build();
	}
}
