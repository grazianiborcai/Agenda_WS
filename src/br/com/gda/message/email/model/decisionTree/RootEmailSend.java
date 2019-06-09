package br.com.gda.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.message.email.model.action.StdEmailMergeToSelect;
import br.com.gda.message.email.model.checker.EmailCheckSend;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmailSend extends DeciTreeWriteTemplate<EmailInfo> {
	
	public RootEmailSend(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmailInfo> buildDecisionCheckerHook(DeciTreeOption<EmailInfo> option) {		
		List<ModelChecker<EmailInfo>> queue = new ArrayList<>();		
		ModelChecker<EmailInfo> checker;	
		
		checker = new EmailCheckSend();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStd<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmailInfo> select = new StdEmailMergeToSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
