package br.com.mind5.message.emailWelcome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.model.action.EmacomeVisiEnforceEmabody;
import br.com.mind5.message.emailWelcome.model.action.EmacomeVisiSendEmail;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckHasOwnelis;
import br.com.mind5.message.emailWelcome.model.checker.EmacomeCheckHasPersolis;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmacomeNodeSend extends DeciTreeTemplateWrite<EmacomeInfo> {
	
	public EmacomeNodeSend(DeciTreeOption<EmacomeInfo> option) {
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
		checker = new EmacomeCheckHasPersolis(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmacomeCheckHasOwnelis(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmacomeInfo>> buildActionsOnPassedHook(DeciTreeOption<EmacomeInfo> option) {
		List<ActionStd<EmacomeInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmacomeInfo> enforceEmabody = new ActionStdCommom<EmacomeInfo>(option, EmacomeVisiEnforceEmabody.class);	
		ActionLazy<EmacomeInfo> send = new ActionLazyCommom<EmacomeInfo>(option, EmacomeVisiSendEmail.class);
		
		enforceEmabody.addPostAction(send);
		
		actions.add(enforceEmabody);		
		return actions;
	}
}
