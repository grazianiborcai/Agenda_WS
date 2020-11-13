package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeNodeSend;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeMergeUselis;
import br.com.mind5.message.emailWelcome.model.action.StdEmacomeMergeOwnelis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
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
	
	
	
	@Override protected List<ActionStdV2<EmacomeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmacomeInfo> option) {
		List<ActionStdV2<EmacomeInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<EmacomeInfo> mergeOwnelis = new StdEmacomeMergeOwnelis(option);
		ActionLazy<EmacomeInfo> mergeUselis = new LazyEmacomeMergeUselis(option.conn, option.schemaName);
		ActionLazy<EmacomeInfo> nodeL1 = new LazyEmacomeNodeSend(option.conn, option.schemaName);	
		
		mergeOwnelis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(nodeL1);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
}
