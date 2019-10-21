package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.LazyEmailSendMessage;
import br.com.mind5.message.email.model.action.StdEmailMergeToSelect;
import br.com.mind5.message.email.model.checker.EmailCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmailSend extends DeciTreeWriteTemplate<EmailInfo> {
	
	public NodeEmailSend(DeciTreeOption<EmailInfo> option) {
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
		ActionLazy<EmailInfo> sendMessage = new LazyEmailSendMessage(option.conn, option.schemaName);
		
		select.addPostAction(sendMessage);
		//TODO: gravar em log os envios de e-mails
		actions.add(select);		
		return actions;
	}
}
