package br.com.mind5.business.materialList.model.action;

import java.util.List;

import br.com.mind5.business.materialList.dao.MatlisDaoSelect;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatlisVisiDaoSelect extends ActionVisitorTemplateStmt<MatlisInfo> {

	public MatlisVisiDaoSelect(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<MatlisInfo> buildStmtExecHook(List<DaoStmtExecOption<MatlisInfo>> stmtOptions) {
		return new MatlisDaoSelect(stmtOptions);
	}
}
