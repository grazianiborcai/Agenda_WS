package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.EmailVisiNodeSend;
import br.com.mind5.message.email.model.action.EmailVisiEnforceEmabody;
import br.com.mind5.message.email.model.action.EmailVisiEnforceScheduleCancellation;
import br.com.mind5.message.email.model.action.EmailVisiMergeEmabody;
import br.com.mind5.message.email.model.checker.EmailCheckScheduleCancellation;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmailRootScheduleCancellation extends DeciTreeTemplateWrite<EmailInfo> {
	
	public EmailRootScheduleCancellation(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmailInfo> buildCheckerHook(DeciTreeOption<EmailInfo> option) {		
		List<ModelChecker<EmailInfo>> queue = new ArrayList<>();		
		ModelChecker<EmailInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmailCheckScheduleCancellation(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStd<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmailInfo> enforceEmabody = new ActionStdCommom<EmailInfo>(option, EmailVisiEnforceEmabody.class);
		ActionLazy<EmailInfo> enforceScheduleCancellation = new ActionLazyCommom<EmailInfo>(option, EmailVisiEnforceScheduleCancellation.class);
		ActionLazy<EmailInfo> mergeEmabody = new ActionLazyCommom<EmailInfo>(option, EmailVisiMergeEmabody.class);
		ActionLazy<EmailInfo> send = new ActionLazyCommom<EmailInfo>(option, EmailVisiNodeSend.class);
		
		enforceEmabody .addPostAction(enforceScheduleCancellation);
		enforceScheduleCancellation.addPostAction(mergeEmabody);
		mergeEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
