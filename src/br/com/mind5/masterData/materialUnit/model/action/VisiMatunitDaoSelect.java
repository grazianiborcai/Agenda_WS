package br.com.mind5.masterData.materialUnit.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialUnit.dao.DaoMatunitSelect;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatunitDaoSelect extends ActionVisitorTemplateStmt<MatunitInfo> {

	public VisiMatunitDaoSelect(DeciTreeOption<MatunitInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatunitInfo> buildStmtExecHook(List<DaoStmtExecOption<MatunitInfo>> stmtOptions) {
		return new DaoMatunitSelect(stmtOptions);
	}
}
