package br.com.mind5.message.emailBody.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.model.action.EmabodyVisiEnforceBody;
import br.com.mind5.message.emailBody.model.action.EmabodyVisiMergeToSelect;
import br.com.mind5.message.emailBody.model.checker.EmabodyCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmabodyRootSelect extends DeciTreeTemplateWrite<EmabodyInfo> {
	
	public EmabodyRootSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmabodyInfo> buildCheckerHook(DeciTreeOption<EmabodyInfo> option) {		
		List<ModelChecker<EmabodyInfo>> queue = new ArrayList<>();		
		ModelChecker<EmabodyInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmabodyCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmabodyInfo>> buildActionsOnPassedHook(DeciTreeOption<EmabodyInfo> option) {
		List<ActionStd<EmabodyInfo>> actions = new ArrayList<>();	
		
		ActionStd<EmabodyInfo> select = new ActionStdCommom<EmabodyInfo>(option, EmabodyVisiMergeToSelect.class);
		ActionLazy<EmabodyInfo> enforceBody = new ActionLazyCommom<EmabodyInfo>(option, EmabodyVisiEnforceBody.class);
		
		select.addPostAction(enforceBody);
		
		actions.add(select);		
		return actions;
	}
}
