package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeEnforceEmabody;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeSendEmail;
import br.com.mind5.message.emailWelcome.model.action.StdEmacomeMergeOwnelis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckSend;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootEmacomeSend extends DeciTreeTemplateWriteV2<EmacomeInfo> {
	
	public RootEmacomeSend(DeciTreeOption<EmacomeInfo> option) {
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
		checker = new EmacomeCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmacomeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmacomeInfo> option) {
		List<ActionStdV1<EmacomeInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<EmacomeInfo> mergeOwnelis = new StdEmacomeMergeOwnelis(option);
		ActionLazyV1<EmacomeInfo> enforceEmabody = new LazyEmacomeEnforceEmabody(option.conn, option.schemaName);		
		ActionLazyV1<EmacomeInfo> send = new LazyEmacomeSendEmail(option.conn, option.schemaName);
		
		mergeOwnelis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
}
