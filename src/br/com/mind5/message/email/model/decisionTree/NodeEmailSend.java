package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.LazyEmailSendMessage;
import br.com.mind5.message.email.model.action.StdEmailMergeToSelect;
import br.com.mind5.message.email.model.checker.EmailCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmailSend extends DeciTreeTemplateWrite<EmailInfo> {
	
	public NodeEmailSend(DeciTreeOption<EmailInfo> option) {
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
		checker = new EmailCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStd<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmailInfo> select = new StdEmailMergeToSelect(option);
		ActionLazy<EmailInfo> sendMessage = new LazyEmailSendMessage(option.conn, option.schemaName);
		
		select.addPostAction(sendMessage);
		//TODO: gravar em log os envios de e-mails
		actions.add(select);		
		return actions;
	}
}
