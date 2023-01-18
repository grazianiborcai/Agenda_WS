package br.com.mind5.masterData.bank.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bank.model.action.BankVisiDaoSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankCheckExist extends ModelCheckerTemplateAction<BankInfo, BankInfo> {
	
	public BankCheckExist(ModelCheckerOption option) {
		super(option, BankInfo.class);
	}
	
	
	
	@Override protected ActionStd<BankInfo> buildActionHook(DeciTreeOption<BankInfo> option) {
		ActionStd<BankInfo> select = new ActionStdCommom<BankInfo>(option, BankVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_F);
		builder.addParam01(SystemCode.BANK);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_F);
		builder.addParam01(SystemCode.BANK);

		return builder.build();
	}
}
