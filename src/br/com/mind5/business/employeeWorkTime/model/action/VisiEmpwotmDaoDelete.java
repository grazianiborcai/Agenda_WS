package br.com.mind5.business.employeeWorkTime.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTime.dao.DaoEmpwotmDelete;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmDaoDelete extends ActionVisitorTemplateStmtV2<EmpwotmInfo> {

	public VisiEmpwotmDaoDelete(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmpwotmInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpwotmInfo>> stmtOptions) {
		return new DaoEmpwotmDelete(stmtOptions);
	}
}
