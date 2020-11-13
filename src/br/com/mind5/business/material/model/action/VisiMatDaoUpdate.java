package br.com.mind5.business.material.model.action;

import java.util.List;

import br.com.mind5.business.material.dao.DaoMatUpdate;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatDaoUpdate extends ActionVisitorTemplateStmt<MatInfo> {

	public VisiMatDaoUpdate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatInfo> buildStmtExecHook(List<DaoStmtExecOption<MatInfo>> stmtOptions) {
		return new DaoMatUpdate(stmtOptions);
	}
}
