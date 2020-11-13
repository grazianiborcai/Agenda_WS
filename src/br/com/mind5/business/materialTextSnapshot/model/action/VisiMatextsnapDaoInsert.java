package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.dao.DaoMatextsnapInsert;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextsnapDaoInsert extends ActionVisitorTemplateStmt<MatextsnapInfo> {

	public VisiMatextsnapDaoInsert(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatextsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextsnapInfo>> stmtOptions) {
		return new DaoMatextsnapInsert(stmtOptions);
	}
}
