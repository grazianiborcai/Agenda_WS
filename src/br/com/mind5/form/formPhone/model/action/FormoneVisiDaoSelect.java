package br.com.mind5.form.formPhone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.form.formPhone.dao.FormoneDaoSelect;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormoneVisiDaoSelect extends ActionVisitorTemplateStmt<FormoneInfo> {

	public FormoneVisiDaoSelect(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<FormoneInfo> buildStmtExecHook(List<DaoStmtExecOption<FormoneInfo>> stmtOptions) {
		return new FormoneDaoSelect(stmtOptions);
	}
}
