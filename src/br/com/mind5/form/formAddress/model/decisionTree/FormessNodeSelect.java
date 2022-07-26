package br.com.mind5.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.FormessVisiEnforceDefault;
import br.com.mind5.form.formAddress.model.action.FormessVisiMergeToSelect;
import br.com.mind5.form.formAddress.model.checker.FormessCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FormessNodeSelect extends DeciTreeTemplateWrite<FormessInfo> {
	
	public FormessNodeSelect(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormessInfo> buildCheckerHook(DeciTreeOption<FormessInfo> option) {
		List<ModelChecker<FormessInfo>> queue = new ArrayList<>();		
		ModelChecker<FormessInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormessCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormessInfo>> buildActionsOnPassedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStd<FormessInfo>> actions = new ArrayList<>();
		
		ActionStd<FormessInfo> select = new ActionStdCommom<FormessInfo>(option, FormessVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FormessInfo>> buildActionsOnFailedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStd<FormessInfo>> actions = new ArrayList<>();
		
		ActionStd<FormessInfo> enforceDefault = new ActionStdCommom<FormessInfo>(option, FormessVisiEnforceDefault.class);
		
		actions.add(enforceDefault);
		return actions;
	}
}
