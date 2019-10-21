package br.com.mind5.business.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.business.form.formPhone.model.checker.FormPhoneCheckCountry;
import br.com.mind5.business.form.formPhone.model.checker.FormPhoneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFormPhoneSelect extends DeciTreeReadTemplate<FormPhoneInfo> {
	
	public RootFormPhoneSelect(DeciTreeOption<FormPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormPhoneInfo> buildDecisionCheckerHook(DeciTreeOption<FormPhoneInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<FormPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<FormPhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new FormPhoneCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new FormPhoneCheckCountry(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<FormPhoneInfo> option) {
		List<ActionStd<FormPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeFormPhoneSelect(option).toAction());
		return actions;
	}
}
