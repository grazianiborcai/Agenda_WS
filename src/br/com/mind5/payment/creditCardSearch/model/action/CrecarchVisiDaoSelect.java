package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.dao.CrecarchDaoSelect;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchVisiDaoSelect extends ActionVisitorTemplateStmt<CrecarchInfo> {

	public CrecarchVisiDaoSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CrecarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CrecarchInfo>> stmtOptions) {
		return new CrecarchDaoSelect(stmtOptions);
	}
}
