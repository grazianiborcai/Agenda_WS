package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeEnforceEmabody;
import br.com.mind5.message.emailWelcome.model.action.LazyEmacomeSendEmail;
import br.com.mind5.message.emailWelcome.model.action.StdEmacomeMergeOwnelis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckSend;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmacomeSend extends DeciTreeWriteTemplate<EmacomeInfo> {
	
	public RootEmacomeSend(DeciTreeOption<EmacomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmacomeInfo> buildDecisionCheckerHook(DeciTreeOption<EmacomeInfo> option) {		
		List<ModelChecker<EmacomeInfo>> queue = new ArrayList<>();		
		ModelChecker<EmacomeInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmacomeCheckSend(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmacomeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmacomeInfo> option) {
		List<ActionStd<EmacomeInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmacomeInfo> mergeOwnelis = new StdEmacomeMergeOwnelis(option);
		ActionLazy<EmacomeInfo> enforceEmabody = new LazyEmacomeEnforceEmabody(option.conn, option.schemaName);
		
		ActionLazy<EmacomeInfo> send = new LazyEmacomeSendEmail(option.conn, option.schemaName);
		
		mergeOwnelis.addPostAction(enforceEmabody);
		enforceEmabody.addPostAction(send);
		
		actions.add(mergeOwnelis);		
		return actions;
	}
}
