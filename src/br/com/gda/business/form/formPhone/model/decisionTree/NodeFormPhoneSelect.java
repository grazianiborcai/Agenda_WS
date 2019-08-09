package br.com.gda.business.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.form.formPhone.model.action.StdFormPhoneEnforceDefault;
import br.com.gda.business.form.formPhone.model.action.StdFormPhoneSelect;
import br.com.gda.business.form.formPhone.model.checker.FormPhoneCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeFormPhoneSelect extends DeciTreeReadTemplate<FormPhoneInfo> {
	
	public NodeFormPhoneSelect(DeciTreeOption<FormPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormPhoneInfo> buildDecisionCheckerHook(DeciTreeOption<FormPhoneInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<FormPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<FormPhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new FormPhoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<FormPhoneInfo> option) {
		List<ActionStd<FormPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormPhoneSelect(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FormPhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<FormPhoneInfo> option) {
		List<ActionStd<FormPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormPhoneEnforceDefault(option));
		return actions;
	}
}
