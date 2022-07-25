package br.com.mind5.discount.discountStoreSearch.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSearch.dao.DisorarchDaoSelect;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorarchVisiDaoSelect extends ActionVisitorTemplateStmt<DisorarchInfo> {

	public DisorarchVisiDaoSelect(DeciTreeOption<DisorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<DisorarchInfo> buildStmtExecHook(List<DaoStmtExecOption<DisorarchInfo>> stmtOptions) {
		return new DisorarchDaoSelect(stmtOptions);
	}
}
