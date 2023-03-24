package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.decisionTree.PhonaultRootSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPhonault extends ModelCheckerTemplateAction<CusparInfo, PhonaultInfo> {	
	
	public CusparCheckPhonault(ModelCheckerOption option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonaultInfo> buildActionHook(DeciTreeOption<PhonaultInfo> option) {
		ActionStd<PhonaultInfo> select = new PhonaultRootSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_REQUIRED_COMPLETE_USER_ACCOUNT);
		builder.addParam01(SystemCode.PHONE);

		return builder.build();
	}
}
