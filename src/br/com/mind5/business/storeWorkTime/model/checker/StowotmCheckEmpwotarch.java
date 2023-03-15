package br.com.mind5.business.storeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.EmpwotarchRootSelect;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckEmpwotarch extends ModelCheckerTemplateAction<StowotmInfo, EmpwotarchInfo> {
	
	public StowotmCheckEmpwotarch(ModelCheckerOption option) {
		super(option, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotarchInfo> buildActionHook(DeciTreeOption<EmpwotarchInfo> option) {
		ActionStd<EmpwotarchInfo> select = new EmpwotarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_DELETE_P2_FIRST_M);
		builder.addParam01(SystemCode.STORE_WTIME);
		builder.addParam02(SystemCode.EMP_WTIME);

		return builder.build();
	}
}
