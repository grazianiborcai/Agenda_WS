package br.com.mind5.business.bankAccount.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.action.BankaccVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccCheckExist extends ModelCheckerTemplateAction<BankaccInfo, BankaccInfo> {	
	
	public BankaccCheckExist(ModelCheckerOption option) {
		super(option, BankaccInfo.class);
	}
	
	
	
	@Override protected ActionStd<BankaccInfo> buildActionHook(DeciTreeOption<BankaccInfo> option) {
		ActionStd<BankaccInfo> select = new ActionStdCommom<BankaccInfo>(option, BankaccVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_F);
		builder.addParam01(SystemCode.BANK_ACCOUNT);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_F);
		builder.addParam01(SystemCode.BANK_ACCOUNT);

		return builder.build();
	}
}
