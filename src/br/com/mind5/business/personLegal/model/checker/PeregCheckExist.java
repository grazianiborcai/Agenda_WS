package br.com.mind5.business.personLegal.model.checker;

import java.sql.Connection;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.model.action.PeregVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregCheckExist extends ModelCheckerTemplateAction<PeregInfo, PeregInfo> {
	
	public PeregCheckExist(ModelCheckerOption option) {
		super(option, PeregInfo.class);
	}
	

	
	@Override protected ActionStd<PeregInfo> buildActionHook(DeciTreeOption<PeregInfo> option) {
		ActionStd<PeregInfo> select = new ActionStdCommom<PeregInfo>(option, PeregVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_F);
		builder.addParam01(SystemCode.LEGAL_PERSON);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_F);
		builder.addParam01(SystemCode.LEGAL_PERSON);

		return builder.build();
	}
}
