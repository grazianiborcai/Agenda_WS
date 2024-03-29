package br.com.mind5.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.action.FormoneVisiDaoSelect;
import br.com.mind5.form.formPhone.model.action.FormoneVisiEnforceDefault;
import br.com.mind5.form.formPhone.model.checker.FormoneCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FormoneNodeSelect extends DeciTreeTemplateRead<FormoneInfo> {
	
	public FormoneNodeSelect(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormoneInfo> buildCheckerHook(DeciTreeOption<FormoneInfo> option) {
		List<ModelChecker<FormoneInfo>> queue = new ArrayList<>();		
		ModelChecker<FormoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormoneInfo>> buildActionsOnPassedHook(DeciTreeOption<FormoneInfo> option) {
		List<ActionStd<FormoneInfo>> actions = new ArrayList<>();
		
		ActionStd<FormoneInfo> select = new ActionStdCommom<FormoneInfo>(option, FormoneVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FormoneInfo>> buildActionsOnFailedHook(DeciTreeOption<FormoneInfo> option) {
		List<ActionStd<FormoneInfo>> actions = new ArrayList<>();
		
		ActionStd<FormoneInfo> enforceDefault = new ActionStdCommom<FormoneInfo>(option, FormoneVisiEnforceDefault.class);
		
		actions.add(enforceDefault);
		return actions;
	}
}
