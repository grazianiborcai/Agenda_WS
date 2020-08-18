package br.com.mind5.business.employeeMaterial.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterial.dao.DaoEmpmatInsert;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmatDaoInsert extends ActionVisitorTemplateStmtV2<EmpmatInfo> {

	public VisiEmpmatDaoInsert(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<EmpmatInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpmatInfo>> stmtOptions) {
		return new DaoEmpmatInsert(stmtOptions);
	}
}
