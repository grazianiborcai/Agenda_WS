package br.com.mind5.business.materialTextDefault.model.action;

import java.util.List;

import br.com.mind5.business.materialTextDefault.dao.MatextaultDaoSelect;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextaultVisiDaoSelect extends ActionVisitorTemplateStmt<MatextaultInfo> {

	public MatextaultVisiDaoSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatextaultInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextaultInfo>> stmtOptions) {
		return new MatextaultDaoSelect(stmtOptions);
	}
}
