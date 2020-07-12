package br.com.mind5.config.sysStorePartitioning.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.action.StdSytotinEnforceEnabled;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSytotinSelectDefault extends DeciTreeTemplateReadV2<SytotinInfo> {
	
	public RootSytotinSelectDefault(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SytotinInfo> buildCheckerHook(DeciTreeOption<SytotinInfo> option) {
		List<ModelCheckerV1<SytotinInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SytotinInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SytotinCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SytotinInfo>> buildActionsOnPassedHook(DeciTreeOption<SytotinInfo> option) {
		List<ActionStdV1<SytotinInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SytotinInfo> enforceEnabled = new StdSytotinEnforceEnabled(option);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
