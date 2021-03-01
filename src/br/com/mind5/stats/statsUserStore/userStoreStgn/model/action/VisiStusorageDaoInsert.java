package br.com.mind5.stats.statsUserStore.userStoreStgn.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.dao.DaoStusorageInsert;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;

final class VisiStusorageDaoInsert extends ActionVisitorTemplateStmt<StusorageInfo> {

	public VisiStusorageDaoInsert(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StusorageInfo> buildStmtExecHook(List<DaoStmtExecOption<StusorageInfo>> stmtOptions) {
		return new DaoStusorageInsert(stmtOptions);
	}
}
