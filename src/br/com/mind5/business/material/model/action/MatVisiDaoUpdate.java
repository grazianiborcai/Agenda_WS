package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.dao.MatDaoUpdate;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatVisiDaoUpdate extends ActionVisitorTemplateStmt<MatInfo> {

	public MatVisiDaoUpdate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatInfo> buildStmtExecHook(List<DaoStmtExecOption<MatInfo>> stmtOptions) {
		return new MatDaoUpdate(stmtOptions);
	}
}
