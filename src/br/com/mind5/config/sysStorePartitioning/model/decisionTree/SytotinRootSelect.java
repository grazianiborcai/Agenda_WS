package br.com.mind5.config.sysStorePartitioning.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.action.SytotinVisiDaoSelect;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class SytotinRootSelect extends DeciTreeTemplateRead<SytotinInfo> {
	
	public SytotinRootSelect(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SytotinInfo> buildCheckerHook(DeciTreeOption<SytotinInfo> option) {
		List<ModelChecker<SytotinInfo>> queue = new ArrayList<>();		
		ModelChecker<SytotinInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SytotinCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SytotinInfo>> buildActionsOnPassedHook(DeciTreeOption<SytotinInfo> option) {
		List<ActionStd<SytotinInfo>> actions = new ArrayList<>();
		
		ActionStd<SytotinInfo> select = new ActionStdCommom<SytotinInfo>(option, SytotinVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
