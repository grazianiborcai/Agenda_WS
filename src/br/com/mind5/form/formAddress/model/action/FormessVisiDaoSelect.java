package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.form.formAddress.dao.FormessDaoSelect;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormessVisiDaoSelect extends ActionVisitorTemplateStmt<FormessInfo> {

	public FormessVisiDaoSelect(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FormessInfo> buildStmtExecHook(List<DaoStmtExecOption<FormessInfo>> stmtOptions) {
		return new FormessDaoSelect(stmtOptions);
	}
}
