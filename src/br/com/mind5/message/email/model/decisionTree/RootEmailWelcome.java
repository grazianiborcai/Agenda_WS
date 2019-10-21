package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.LazyEmailEnforceWelcome;
import br.com.mind5.message.email.model.action.LazyEmailMergeEmabody;
import br.com.mind5.message.email.model.action.LazyEmailNodeSend;
import br.com.mind5.message.email.model.action.StdEmailEnforceEmabody;
import br.com.mind5.message.email.model.checker.EmailCheckWelcome;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmailWelcome extends DeciTreeWriteTemplate<EmailInfo> {
	
	public RootEmailWelcome(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmailInfo> buildDecisionCheckerHook(DeciTreeOption<EmailInfo> option) {		
		List<ModelChecker<EmailInfo>> queue = new ArrayList<>();		
		ModelChecker<EmailInfo> checker;	
		
		checker = new EmailCheckWelcome();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStd<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmailInfo> enforceEmabody = new StdEmailEnforceEmabody(option);
		ActionLazy<EmailInfo> enforceWelcome = new LazyEmailEnforceWelcome(option.conn, option.schemaName);
		ActionLazy<EmailInfo> mergeEmabody = new LazyEmailMergeEmabody(option.conn, option.schemaName);
		ActionLazy<EmailInfo> send = new LazyEmailNodeSend(option.conn, option.schemaName);
		
		enforceEmabody .addPostAction(enforceWelcome);
		enforceWelcome.addPostAction(mergeEmabody);
		mergeEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
