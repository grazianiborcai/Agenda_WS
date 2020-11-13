package br.com.mind5.business.personList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.action.LazyPersolisEnforceRestricted;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPersolisSelectRestricted extends DeciTreeTemplateReadV2<PersolisInfo> {
	
	public RootPersolisSelectRestricted(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersolisInfo> buildCheckerHook(DeciTreeOption<PersolisInfo> option) {
		List<ModelCheckerV1<PersolisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersolisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PersolisInfo>> buildActionsOnPassedHook(DeciTreeOption<PersolisInfo> option) {
		List<ActionStdV2<PersolisInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PersolisInfo> select = new RootPersolisSelect(option).toAction();		
		ActionLazy<PersolisInfo> enforceRestricted = new LazyPersolisEnforceRestricted(option.conn, option.schemaName);	
		
		select.addPostAction(enforceRestricted);		
		
		actions.add(select);		
		return actions;
	}
}
