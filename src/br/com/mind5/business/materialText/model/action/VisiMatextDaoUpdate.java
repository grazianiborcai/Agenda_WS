package br.com.mind5.business.materialText.model.action;

import java.util.List;

import br.com.mind5.business.materialText.dao.DaoMatextUpdate;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextDaoUpdate extends ActionVisitorTemplateStmt<MatextInfo> {

	public VisiMatextDaoUpdate(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatextInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextInfo>> stmtOptions) {
		return new DaoMatextUpdate(stmtOptions);
	}
}
