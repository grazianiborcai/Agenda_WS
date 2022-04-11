package br.com.mind5.business.personBioSearch.model.action;

import java.util.List;

import br.com.mind5.business.personBioSearch.dao.PerbiorchDaoSelect;
import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbiorchVisiDaoSelect extends ActionVisitorTemplateStmt<PerbiorchInfo> {

	public PerbiorchVisiDaoSelect(DeciTreeOption<PerbiorchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PerbiorchInfo> buildStmtExecHook(List<DaoStmtExecOption<PerbiorchInfo>> stmtOptions) {
		return new PerbiorchDaoSelect(stmtOptions);
	}
}
