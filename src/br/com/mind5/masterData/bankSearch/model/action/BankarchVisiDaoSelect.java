package br.com.mind5.masterData.bankSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.bankSearch.dao.BankarchDaoSelect;
import br.com.mind5.masterData.bankSearch.info.BankarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankarchVisiDaoSelect extends ActionVisitorTemplateStmt<BankarchInfo> {

	public BankarchVisiDaoSelect(DeciTreeOption<BankarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankarchInfo> buildStmtExecHook(List<DaoStmtExecOption<BankarchInfo>> stmtOptions) {
		return new BankarchDaoSelect(stmtOptions);
	}
}
