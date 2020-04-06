package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.LazyEmailSendMessage;
import br.com.mind5.message.email.model.action.StdEmailMergeToSelect;
import br.com.mind5.message.email.model.checker.EmailCheckSend;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmailSend extends DeciTreeTemplateWrite<EmailInfo> {
	
	public NodeEmailSend(DeciTreeOption<EmailInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmailInfo> buildCheckerHook(DeciTreeOption<EmailInfo> option) {		
		List<ModelCheckerV1<EmailInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmailInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmailCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStdV1<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmailInfo> select = new StdEmailMergeToSelect(option);
		ActionLazyV1<EmailInfo> sendMessage = new LazyEmailSendMessage(option.conn, option.schemaName);
		
		select.addPostAction(sendMessage);
		//TODO: gravar em log os envios de e-mails
		actions.add(select);		
		return actions;
	}
}
