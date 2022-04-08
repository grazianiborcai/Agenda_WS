package br.com.mind5.business.materialTextSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialTextSearch.dao.MatextarchDaoSelect;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextarchVisiDaoSelect extends ActionVisitorTemplateStmt<MatextarchInfo> {

	public MatextarchVisiDaoSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatextarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatextarchInfo>> stmtOptions) {
		return new MatextarchDaoSelect(stmtOptions);
	}
}
