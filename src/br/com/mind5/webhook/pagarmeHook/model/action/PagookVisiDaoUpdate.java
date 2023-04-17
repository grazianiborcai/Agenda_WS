package br.com.mind5.webhook.pagarmeHook.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.pagarmeHook.dao.PagookDaoUpdate;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookVisiDaoUpdate extends ActionVisitorTemplateStmt<PagookInfo> {

	public PagookVisiDaoUpdate(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PagookInfo> buildStmtExecHook(List<DaoStmtExecOption<PagookInfo>> stmtOptions) {
		return new PagookDaoUpdate(stmtOptions);
	}
}
