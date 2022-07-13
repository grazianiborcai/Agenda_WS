package br.com.mind5.file.sysFileImageSnapshot.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.sysFileImageSnapshot.dao.FimgysapDaoSelect;
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysapVisiDaoSelect extends ActionVisitorTemplateStmt<FimgysapInfo> {

	public FimgysapVisiDaoSelect(DeciTreeOption<FimgysapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimgysapInfo> buildStmtExecHook(List<DaoStmtExecOption<FimgysapInfo>> stmtOptions) {
		return new FimgysapDaoSelect(stmtOptions);
	}
}
