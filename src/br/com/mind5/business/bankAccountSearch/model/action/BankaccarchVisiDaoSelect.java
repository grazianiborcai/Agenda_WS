package br.com.mind5.business.bankAccountSearch.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSearch.dao.BankaccarchDaoSelect;
import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccarchVisiDaoSelect extends ActionVisitorTemplateStmt<BankaccarchInfo> {

	public BankaccarchVisiDaoSelect(DeciTreeOption<BankaccarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankaccarchInfo> buildStmtExecHook(List<DaoStmtExecOption<BankaccarchInfo>> stmtOptions) {
		return new BankaccarchDaoSelect(stmtOptions);
	}
}
