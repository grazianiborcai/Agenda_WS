package br.com.mind5.business.materialStockSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStockSearch.dao.MatocarchDaoSelect;
import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatocarchVisiDaoSelect extends ActionVisitorTemplateStmt<MatocarchInfo> {

	public MatocarchVisiDaoSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatocarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatocarchInfo>> stmtOptions) {
		return new MatocarchDaoSelect(stmtOptions);
	}
}
