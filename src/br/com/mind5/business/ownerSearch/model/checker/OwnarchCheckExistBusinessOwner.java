package br.com.mind5.business.ownerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.decisionTree.OwnarchRootSelectBusinessOwner;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchCheckExistBusinessOwner extends ModelCheckerTemplateAction<OwnarchInfo, OwnarchInfo> {
	
	public OwnarchCheckExistBusinessOwner(ModelCheckerOption option) {
		super(option, OwnarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<OwnarchInfo> buildActionHook(DeciTreeOption<OwnarchInfo> option) {
		ActionStd<OwnarchInfo> select = new OwnarchRootSelectBusinessOwner(option).toAction();
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultTrueHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_ALREADY_EXIST_M);
		builder.addParam01(SystemCode.OWNER_SEARCH);

		return builder.build();
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_NOT_FOUND_M);
		builder.addParam01(SystemCode.OWNER_SEARCH);

		return builder.build();
	}
}
