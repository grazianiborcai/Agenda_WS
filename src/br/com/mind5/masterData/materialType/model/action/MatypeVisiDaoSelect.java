package br.com.mind5.masterData.materialType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialType.dao.MatypeDaoSelect;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatypeVisiDaoSelect extends ActionVisitorTemplateStmt<MatypeInfo> {

	public MatypeVisiDaoSelect(DeciTreeOption<MatypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatypeInfo> buildStmtExecHook(List<DaoStmtExecOption<MatypeInfo>> stmtOptions) {
		return new MatypeDaoSelect(stmtOptions);
	}
}
