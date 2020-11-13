package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.dao.DaoMatmovInsert;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovDaoInsert extends ActionVisitorTemplateStmt<MatmovInfo> {

	public VisiMatmovDaoInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatmovInfo> buildStmtExecHook(List<DaoStmtExecOption<MatmovInfo>> stmtOptions) {
		return new DaoMatmovInsert(stmtOptions);
	}
}
