package br.com.mind5.config.sysStoreBusinessContent.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.action.LazySytorbcRootSelect;
import br.com.mind5.config.sysStoreBusinessContent.model.action.StdSytorbcEnforceEnabled;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootSytorbcSelectEnabled extends DeciTreeTemplateReadV2<SytorbcInfo> {
	
	public RootSytorbcSelectEnabled(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SytorbcInfo> buildCheckerHook(DeciTreeOption<SytorbcInfo> option) {
		List<ModelCheckerV1<SytorbcInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SytorbcInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SytorbcInfo>> buildActionsOnPassedHook(DeciTreeOption<SytorbcInfo> option) {
		List<ActionStdV1<SytorbcInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SytorbcInfo> enforceEnabled = new StdSytorbcEnforceEnabled(option);
		ActionLazyV1<SytorbcInfo> select = new LazySytorbcRootSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
