package br.com.mind5.masterData.bankHolderTypeSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankHolderTypeSearch.dao.BankoldyperchDaoSelect;
import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankoldyperchVisiDaoSelect extends ActionVisitorTemplateStmt<BankoldyperchInfo> {

	public BankoldyperchVisiDaoSelect(DeciTreeOption<BankoldyperchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankoldyperchInfo> buildStmtExecHook(List<DaoStmtExecOption<BankoldyperchInfo>> stmtOptions) {
		return new BankoldyperchDaoSelect(stmtOptions);
	}
}
