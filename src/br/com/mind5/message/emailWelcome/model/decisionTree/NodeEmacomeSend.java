package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeSendEmail;
import br.com.mind5.message.emailWelcome.model.action.StdEmacomeEnforceEmabody;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckHasOwnelis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckHasPersolis;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmacomeSend extends DeciTreeTemplateWriteV2<EmacomeInfo> {
	
	public NodeEmacomeSend(DeciTreeOption<EmacomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmacomeInfo> buildCheckerHook(DeciTreeOption<EmacomeInfo> option) {		
		List<ModelCheckerV1<EmacomeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmacomeInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmacomeCheckHasPersolis(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmacomeCheckHasOwnelis(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmacomeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmacomeInfo> option) {
		List<ActionStdV1<EmacomeInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmacomeInfo> enforceEmabody = new StdEmacomeEnforceEmabody(option);	
		ActionLazyV1<EmacomeInfo> send = new LazyEmacomeSendEmail(option.conn, option.schemaName);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}