package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.petSearch.dao.DaoPetarchSelect;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerarchDaoSelect extends ActionVisitorTemplateStmt<PetarchInfo> {

	public VisiPerarchDaoSelect(DeciTreeOption<PetarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PetarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PetarchInfo>> stmtOptions) {
		return new DaoPetarchSelect(stmtOptions);
	}
}
