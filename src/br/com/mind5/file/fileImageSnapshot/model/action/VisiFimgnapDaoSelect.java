package br.com.mind5.file.fileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImageSnapshot.dao.DaoFimgnapSelect;
import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgnapDaoSelect extends ActionVisitorTemplateStmt<FimgnapInfo> {

	public VisiFimgnapDaoSelect(DeciTreeOption<FimgnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimgnapInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgnapInfo>> stmtOptions) {
		return new DaoFimgnapSelect(stmtOptions);
	}
}
