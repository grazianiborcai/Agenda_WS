package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.decisionTree.AddaultRootSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddault extends ModelCheckerTemplateAction<CusparInfo, AddaultInfo> {
	
	public CusparCheckAddault(ModelCheckerOption option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddaultInfo> buildActionHook(DeciTreeOption<AddaultInfo> option) {
		ActionStd<AddaultInfo> select = new AddaultRootSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_REQUIRED_COMPLETE_USER_ACCOUNT);
		builder.addParam01(SystemCode.ADDRESS);

		return builder.build();
	}
}
