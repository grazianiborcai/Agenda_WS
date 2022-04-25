package br.com.mind5.business.employeeLunchTimeConflict.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.dao.EmpulocoDaoSelect;
import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulocoInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpulocoVisiDaoSelect extends ActionVisitorTemplateStmt<EmpulocoInfo> {

	public EmpulocoVisiDaoSelect(DeciTreeOption<EmpulocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<EmpulocoInfo> buildStmtExecHook(List<DaoStmtExecOption<EmpulocoInfo>> stmtOptions) {
		return new EmpulocoDaoSelect(stmtOptions);
	}
}
