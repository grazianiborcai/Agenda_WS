package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.dao.DaoEmpmatSelect;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmatDaoSelect extends ActionVisitorTemplateStmt<EmpmatInfo> {

	public VisiEmpmatDaoSelect(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpmatInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpmatInfo>> stmtOptions) {
		return new DaoEmpmatSelect(stmtOptions);
	}
}
