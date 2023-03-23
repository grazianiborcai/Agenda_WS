package br.com.mind5.payment.creditCard.model.checker;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchCopier;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.AddarchRootSelectUserAddress;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardCheckAddarch extends ModelCheckerTemplateAction<CrecardInfo, AddarchInfo> {	
	
	public CrecardCheckAddarch(ModelCheckerOption option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddarchInfo> buildActionHook(DeciTreeOption<AddarchInfo> option) {
		ActionStd<AddarchInfo> select = new AddarchRootSelectUserAddress(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<AddarchInfo> toActionClassHook(List<CrecardInfo> recordInfos) {
		return AddarchCopier.copyFromCrecard(recordInfos);
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_NOT_FOUND_M);
		builder.addParam01(SystemCode.CREDIT_CARD);
		builder.addParam02(SystemCode.ADDRESS);

		return builder.build();
	}
}
