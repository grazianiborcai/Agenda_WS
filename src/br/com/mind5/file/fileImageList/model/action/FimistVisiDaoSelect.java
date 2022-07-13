package br.com.mind5.file.fileImageList.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.file.fileImageList.dao.FimistDaoSelect;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimistVisiDaoSelect extends ActionVisitorTemplateStmt<FimistInfo> {

	public FimistVisiDaoSelect(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FimistInfo> buildStmtExecHook(List<DaoStmtExecOption<FimistInfo>> stmtOptions) {
		return new FimistDaoSelect(stmtOptions);
	}
}
