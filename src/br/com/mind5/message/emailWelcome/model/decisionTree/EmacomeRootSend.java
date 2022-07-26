package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.EmacomeVisiNodeSend;
import br.com.mind5.message.emailWelcome.model.action.EmacomeVisiMergeOwnelis;
import br.com.mind5.message.emailWelcome.model.action.EmacomeVisiMergeUselis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmacomeRootSend extends DeciTreeTemplateWrite<EmacomeInfo> {
	
	public EmacomeRootSend(DeciTreeOption<EmacomeInfo> option) {
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
		
		ActionStd<EmacomeInfo> mergeOwnelis = new ActionStdCommom<EmacomeInfo>(option, EmacomeVisiMergeOwnelis.class);
		ActionLazy<EmacomeInfo> mergeUselis = new ActionLazyCommom<EmacomeInfo>(option, EmacomeVisiMergeUselis.class);
		ActionLazy<EmacomeInfo> nodeL1 = new ActionLazyCommom<EmacomeInfo>(option, EmacomeVisiNodeSend.class);	
		
		mergeOwnelis.addPostAction(mergeUselis);
		mergeUselis.addPostAction(nodeL1);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
}
