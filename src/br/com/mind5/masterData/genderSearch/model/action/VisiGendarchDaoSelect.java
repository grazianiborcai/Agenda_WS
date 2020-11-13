package br.com.mind5.masterData.genderSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.genderSearch.dao.DaoGendarchSelect;
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGendarchDaoSelect extends ActionVisitorTemplateStmt<GendarchInfo> {

	public VisiGendarchDaoSelect(DeciTreeOption<GendarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<GendarchInfo> buildStmtExecHook(List<DaoStmtExecOption<GendarchInfo>> stmtOptions) {
		return new DaoGendarchSelect(stmtOptions);
	}
}
