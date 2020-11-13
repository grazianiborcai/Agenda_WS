package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.LazyPerarchRootSelect;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerarchSelectAuth extends DeciTreeTemplateRead<PerarchInfo> {
	
	public RootPerarchSelectAuth(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerarchInfo> buildCheckerHook(DeciTreeOption<PerarchInfo> option) {
		List<ModelChecker<PerarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PerarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStd<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerarchInfo> nodeSytotin = new NodePerarchSytotinL1(option).toAction();
		ActionLazy<PerarchInfo> select = new LazyPerarchRootSelect(option.conn, option.schemaName);		
		
		nodeSytotin.addPostAction(select);

		actions.add(nodeSytotin);		
		return actions;
	}
}
