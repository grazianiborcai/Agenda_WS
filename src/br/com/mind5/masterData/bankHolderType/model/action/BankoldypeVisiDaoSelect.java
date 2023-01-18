package br.com.mind5.masterData.bankHolderType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.bankHolderType.dao.BankoldypeDaoSelect;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankoldypeVisiDaoSelect extends ActionVisitorTemplateStmt<BankoldypeInfo> {

	public BankoldypeVisiDaoSelect(DeciTreeOption<BankoldypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<BankoldypeInfo> buildStmtExecHook(List<DaoStmtExecOption<BankoldypeInfo>> stmtOptions) {
		return new BankoldypeDaoSelect(stmtOptions);
	}
}
