package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.sysFileImage.dao.DaoFimgysInsert;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFimgysDaoInsert extends ActionVisitorTemplateStmt<FimgysInfo> {

	public VisiFimgysDaoInsert(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimgysInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgysInfo>> stmtOptions) {
		return new DaoFimgysInsert(stmtOptions);
	}
}
