package br.com.mind5.message.email.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.email.info.EmailInfo;
import br.com.mind5.message.email.model.action.LazyEmailEnforceScheduleConfirmation;
import br.com.mind5.message.email.model.action.LazyEmailMergeEmabody;
import br.com.mind5.message.email.model.action.LazyEmailNodeSend;
import br.com.mind5.message.email.model.action.StdEmailEnforceEmabody;
import br.com.mind5.message.email.model.checker.EmailCheckScheduleConfirmation;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmailScheduleConfirmation extends DeciTreeTemplateWriteV2<EmailInfo> {
	
	public RootEmailScheduleConfirmation(DeciTreeOption<EmailInfo> option) {
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
		checker = new EmailCheckScheduleConfirmation(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmailInfo>> buildActionsOnPassedHook(DeciTreeOption<EmailInfo> option) {
		List<ActionStdV1<EmailInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmailInfo> enforceEmabody = new StdEmailEnforceEmabody(option);
		ActionLazy<EmailInfo> enforceScheduleConfirmation = new LazyEmailEnforceScheduleConfirmation(option.conn, option.schemaName);
		ActionLazy<EmailInfo> mergeEmabody = new LazyEmailMergeEmabody(option.conn, option.schemaName);
		ActionLazy<EmailInfo> send = new LazyEmailNodeSend(option.conn, option.schemaName);
		
		enforceEmabody .addPostAction(enforceScheduleConfirmation);
		enforceScheduleConfirmation.addPostAction(mergeEmabody);
		mergeEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
