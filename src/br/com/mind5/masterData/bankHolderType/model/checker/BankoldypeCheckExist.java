package br.com.mind5.masterData.bankHolderType.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.masterData.bankHolderType.model.action.BankoldypeVisiDaoSelect;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankoldypeCheckExist extends ModelCheckerTemplateAction<BankoldypeInfo, BankoldypeInfo> {
	
	public BankoldypeCheckExist(ModelCheckerOption option) {
		super(option, BankoldypeInfo.class);
	}
	
	
	
	@Override protected ActionStd<BankoldypeInfo> buildActionHook(DeciTreeOption<BankoldypeInfo> option) {
		ActionStd<BankoldypeInfo> select = new ActionStdCommom<BankoldypeInfo>(option, BankoldypeVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_F);
		builder.addParam01(SystemCode.BANK_HOLDER_TYPE);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_F);
		builder.addParam01(SystemCode.BANK_HOLDER_TYPE);

		return builder.build();
	}
}
