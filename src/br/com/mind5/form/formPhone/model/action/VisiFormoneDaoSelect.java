package br.com.mind5.form.formPhone.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.form.formPhone.dao.DaoFormoneSelect;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormoneDaoSelect extends ActionVisitorTemplateStmtV2<FormoneInfo>{

	public VisiFormoneDaoSelect(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FormoneInfo> buildStmtExecHook(List<DaoStmtExecOption<FormoneInfo>> stmtOptions) {
		return new DaoFormoneSelect(stmtOptions);
	}
}
