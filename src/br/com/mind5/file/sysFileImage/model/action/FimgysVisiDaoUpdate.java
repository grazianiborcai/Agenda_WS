package br.com.mind5.file.sysFileImage.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.sysFileImage.dao.FimgysDaoUpdate;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysVisiDaoUpdate extends ActionVisitorTemplateStmt<FimgysInfo> {

	public FimgysVisiDaoUpdate(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimgysInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgysInfo>> stmtOptions) {
		return new FimgysDaoUpdate(stmtOptions);
	}
}
