package br.com.mind5.business.bankAccountSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.model.action.BankaccnapVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapCheckExist extends ModelCheckerTemplateAction<BankaccnapInfo, BankaccnapInfo> {	
	
	public BankaccnapCheckExist(ModelCheckerOption option) {
		super(option, BankaccnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<BankaccnapInfo> buildActionHook(DeciTreeOption<BankaccnapInfo> option) {
		ActionStd<BankaccnapInfo> select = new ActionStdCommom<BankaccnapInfo>(option, BankaccnapVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_F);
		builder.addParam01(SystemCode.BANK_ACCOUNT_SNAPSHOT);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_F);
		builder.addParam01(SystemCode.BANK_ACCOUNT_SNAPSHOT);

		return builder.build();
	}
}
