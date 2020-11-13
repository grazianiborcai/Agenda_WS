package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSnapshot.dao.DaoMatextsnapSelect;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatextsnapDaoSelect extends ActionVisitorTemplateStmt<MatextsnapInfo> {

	public VisiMatextsnapDaoSelect(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatextsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextsnapInfo>> stmtOptions) {
		return new DaoMatextsnapSelect(stmtOptions);
	}
}
