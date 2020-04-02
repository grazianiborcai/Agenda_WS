package br.com.mind5.business.employeeWorkTime.model.checker;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.action.LazyEmpwotmSelect;
import br.com.mind5.business.employeeWorkTime.model.action.StdEmpwotmEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmCheckSoftDelete extends ModelCheckerTemplateAction<EmpwotmInfo, EmpwotmInfo> {
	
	public EmpwotmCheckSoftDelete(ModelCheckerOption option) {
		super(option, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpwotmInfo> buildActionHook(DeciTreeOption<EmpwotmInfo> option) {
		ActionStdV1<EmpwotmInfo> enforceDel = new StdEmpwotmEnforceDel(option);
		ActionLazyV1<EmpwotmInfo> select = new LazyEmpwotmSelect(option.conn, option.schemaName);		
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_WTIME_FLAGGED_AS_DELETED;	
	}
}
