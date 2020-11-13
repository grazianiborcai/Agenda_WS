package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeNodeSend;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeMergeUselis;
import br.com.mind5.message.emailWelcome.model.action.StdEmacomeMergeOwnelis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmacomeSend extends DeciTreeTemplateWrite<EmacomeInfo> {
	
	public RootEmacomeSend(DeciTreeOption<EmacomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmacomeInfo> buildCheckerHook(DeciTreeOption<EmacomeInfo> option) {		
		List<ModelChecker<EmacomeInfo>> queue = new ArrayList<>();		
		ModelChecker<EmacomeInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmacomeCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmacomeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmacomeInfo> option) {
		List<ActionStd<EmacomeInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmacomeInfo> mergeOwnelis = new StdEmacomeMergeOwnelis(option);
		ActionLazy<EmacomeInfo> mergeUselis = new LazyEmacomeMergeUselis(option.conn, option.schemaName);
		ActionLazy<EmacomeInfo> nodeL1 = new LazyEmacomeNodeSend(option.conn, option.schemaName);	
		
		mergeOwnelis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(nodeL1);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
}
