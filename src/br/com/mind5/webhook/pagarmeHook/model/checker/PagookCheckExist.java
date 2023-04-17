package br.com.mind5.webhook.pagarmeHook.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiDaoSelect;

public final class PagookCheckExist extends ModelCheckerTemplateAction<PagookInfo, PagookInfo> {
	
	public PagookCheckExist(ModelCheckerOption option) {
		super(option, PagookInfo.class);
	}
	
	
	
	@Override protected ActionStd<PagookInfo> buildActionHook(DeciTreeOption<PagookInfo> option) {
		ActionStd<PagookInfo> select = new ActionStdCommom<PagookInfo>(option, PagookVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_M);
		builder.addParam01(SystemCode.WHOOK_PAGARME);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_M);
		builder.addParam01(SystemCode.WHOOK_PAGARME);

		return builder.build();
	}
}
