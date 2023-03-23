package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelectUserPhone;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckPhonarch extends ModelCheckerTemplateAction<CrecardInfo, PhonarchInfo> {	
	
	public CrecardCheckPhonarch(ModelCheckerOption option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonarchInfo> buildActionHook(DeciTreeOption<PhonarchInfo> option) {
		ActionStd<PhonarchInfo> select = new PhonarchRootSelectUserPhone(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<PhonarchInfo> toActionClassHook(List<CrecardInfo> recordInfos) {
		return PhonarchCopier.copyFromCrecard(recordInfos);
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_NOT_FOUND_M);
		builder.addParam01(SystemCode.CREDIT_CARD);
		builder.addParam02(SystemCode.PHONE);

		return builder.build();
	}
}
