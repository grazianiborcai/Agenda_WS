package br.com.mind5.business.materialMovement.model.action;

import java.util.List;

import br.com.mind5.business.materialMovement.dao.DaoMatmovUpdate;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatmovDaoUpdate extends ActionVisitorTemplateStmt<MatmovInfo> {

	public VisiMatmovDaoUpdate(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatmovInfo> buildStmtExecHook(List<DaoStmtExecOption<MatmovInfo>> stmtOptions) {
		return new DaoMatmovUpdate(stmtOptions);
	}
}
