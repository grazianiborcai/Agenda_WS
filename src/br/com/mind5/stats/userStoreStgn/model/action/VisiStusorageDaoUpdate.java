package br.com.mind5.stats.userStoreStgn.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreStgn.dao.DaoStusorageUpdate;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;

final class VisiStusorageDaoUpdate extends ActionVisitorTemplateStmt<StusorageInfo> {

	public VisiStusorageDaoUpdate(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorageInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorageInfo>> stmtOptions) {
		return new DaoStusorageUpdate(stmtOptions);
	}
}
