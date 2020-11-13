package br.com.mind5.form.formAddressSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.form.formAddressSearch.dao.DaoFormesarchSelect;
import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormesarchDaoSelect extends ActionVisitorTemplateStmt<FormesarchInfo> {

	public VisiFormesarchDaoSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FormesarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FormesarchInfo>> stmtOptions) {
		return new DaoFormesarchSelect(stmtOptions);
	}
}
