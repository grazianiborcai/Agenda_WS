package br.com.mind5.file.filePath.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.filePath.dao.DaoFathSelect;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFathDaoSelect extends ActionVisitorTemplateStmt<FathInfo> {

	public VisiFathDaoSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FathInfo> buildStmtExecHook(List<DaoStmtExecOption<FathInfo>> stmtOptions) {
		return new DaoFathSelect(stmtOptions);
	}
}
