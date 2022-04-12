package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.PerarchVisiEnforceStore;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckSytotin;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PerarchNodeSytotinL1 extends DeciTreeTemplateRead<PerarchInfo> {
	
	public PerarchNodeSytotinL1(DeciTreeOption<PerarchInfo> option) {
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
		checker = new PerarchCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStd<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerarchInfo> nodeL2 = new PerarchNodeSytotinL2(option).toAction();	

		actions.add(nodeL2);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PerarchInfo>> buildActionsOnFailedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStd<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerarchInfo> obfuscateStore = new ActionStdCommom<PerarchInfo>(option, PerarchVisiEnforceStore.class);	

		actions.add(obfuscateStore);		
		return actions;
	}
}
