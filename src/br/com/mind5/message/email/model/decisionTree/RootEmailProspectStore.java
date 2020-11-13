package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.LazyEmailEnforceProspectStore;
import br.com.mind5.message.email.model.action.LazyEmailMergeEmabody;
import br.com.mind5.message.email.model.action.LazyEmailNodeSend;
import br.com.mind5.message.email.model.action.StdEmailEnforceEmabody;
import br.com.mind5.message.email.model.checker.EmailCheckProspectStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmailProspectStore extends DeciTreeTemplateWrite<EmailInfo> {
	
	public RootEmailProspectStore(DeciTreeOption<EmailInfo> option) {
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
		checker = new EmailCheckProspectStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStd<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmailInfo> enforceEmabody = new StdEmailEnforceEmabody(option);
		ActionLazy<EmailInfo> enforceProspectStore = new LazyEmailEnforceProspectStore(option.conn, option.schemaName);
		ActionLazy<EmailInfo> mergeEmabody = new LazyEmailMergeEmabody(option.conn, option.schemaName);
		ActionLazy<EmailInfo> send = new LazyEmailNodeSend(option.conn, option.schemaName);
		
		enforceEmabody .addPostAction(enforceProspectStore);
		enforceProspectStore.addPostAction(mergeEmabody);
		mergeEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
