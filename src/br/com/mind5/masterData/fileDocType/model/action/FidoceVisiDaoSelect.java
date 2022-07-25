package br.com.mind5.masterData.fileDocType.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.fileDocType.dao.FidoceDaoSelect;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FidoceVisiDaoSelect extends ActionVisitorTemplateStmt<FidoceInfo> {

	public FidoceVisiDaoSelect(DeciTreeOption<FidoceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FidoceInfo> buildStmtExecHook(List<DaoStmtExecOption<FidoceInfo>> stmtOptions) {
		return new FidoceDaoSelect(stmtOptions);
	}
}
