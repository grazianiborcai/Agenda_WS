package br.com.mind5.masterData.bankAccountType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankAccountType.model.action.BankacypeVisiDaoSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankacypeCheckExist extends ModelCheckerTemplateAction<BankacypeInfo, BankacypeInfo> {
	
	public BankacypeCheckExist(ModelCheckerOption option) {
		super(option, BankacypeInfo.class);
	}
	
	
	
	@Override protected ActionStd<BankacypeInfo> buildActionHook(DeciTreeOption<BankacypeInfo> option) {
		ActionStd<BankacypeInfo> select = new ActionStdCommom<BankacypeInfo>(option, BankacypeVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_F);
		builder.addParam01(SystemCode.BANK_ACCOUNT_TYPE);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_F);
		builder.addParam01(SystemCode.BANK_ACCOUNT_TYPE);

		return builder.build();
	}
}
