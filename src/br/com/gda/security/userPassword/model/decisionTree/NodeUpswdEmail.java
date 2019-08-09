package br.com.gda.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.action.StdUpswdSuccess;
import br.com.gda.security.userPassword.model.checker.UpswdCheckHasEmail;
import br.com.gda.security.userPassword.model.checker.UpswdCheckHasPerson;

public final class NodeUpswdEmail extends DeciTreeReadTemplate<UpswdInfo> {
	
	public NodeUpswdEmail(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		
		checker = new UpswdCheckHasPerson();
		queue.add(checker);
		
		checker = new UpswdCheckHasEmail();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		
		ActionStd<UpswdInfo> success = new StdUpswdSuccess(option);
		//TODO: enviar e-mail
		
		actions.add(success);		
		return actions;
	}
}
