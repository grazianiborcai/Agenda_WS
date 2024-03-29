package br.com.mind5.masterData.materialUnitSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialUnitSearch.dao.MatunitarchDaoSelect;
import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatunitarchVisiDaoSelect extends ActionVisitorTemplateStmt<MatunitarchInfo> {

	public MatunitarchVisiDaoSelect(DeciTreeOption<MatunitarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatunitarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatunitarchInfo>> stmtOptions) {
		return new MatunitarchDaoSelect(stmtOptions);
	}
}
