package br.com.mind5.business.storeTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSnapshot.dao.DaoStorextsnapSelect;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextsnapDaoSelect extends ActionVisitorTemplateStmt<StorextsnapInfo> {

	public VisiStorextsnapDaoSelect(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorextsnapInfo> buildStmtExecHook(List<DaoStmtExecOption<StorextsnapInfo>> stmtOptions) {
		return new DaoStorextsnapSelect(stmtOptions);
	}
}
