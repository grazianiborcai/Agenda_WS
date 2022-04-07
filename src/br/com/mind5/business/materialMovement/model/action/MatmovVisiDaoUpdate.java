package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.dao.MatmovDaoUpdate;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovVisiDaoUpdate extends ActionVisitorTemplateStmt<MatmovInfo> {

	public MatmovVisiDaoUpdate(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatmovInfo> buildStmtExecHook(List<DaoStmtExecOption<MatmovInfo>> stmtOptions) {
		return new MatmovDaoUpdate(stmtOptions);
	}
}
