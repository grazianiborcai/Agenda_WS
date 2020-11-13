package br.com.mind5.config.sysStoreBusinessContent.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;
import br.com.mind5.config.sysStoreBusinessContent.model.action.LazySytorbcRootSelect;
import br.com.mind5.config.sysStoreBusinessContent.model.action.StdSytorbcEnforceEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootSytorbcSelectEnabled extends DeciTreeTemplateRead<SytorbcInfo> {
	
	public RootSytorbcSelectEnabled(DeciTreeOption<SytorbcInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SytorbcInfo> buildCheckerHook(DeciTreeOption<SytorbcInfo> option) {
		List<ModelChecker<SytorbcInfo>> queue = new ArrayList<>();		
		ModelChecker<SytorbcInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SytorbcInfo>> buildActionsOnPassedHook(DeciTreeOption<SytorbcInfo> option) {
		List<ActionStd<SytorbcInfo>> actions = new ArrayList<>();
		
		ActionStd<SytorbcInfo> enforceEnabled = new StdSytorbcEnforceEnabled(option);
		ActionLazy<SytorbcInfo> select = new LazySytorbcRootSelect(option.conn, option.schemaName);
		
		enforceEnabled.addPostAction(select);
		
		actions.add(enforceEnabled);
		return actions;
	}
}
