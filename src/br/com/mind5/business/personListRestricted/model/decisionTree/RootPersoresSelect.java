package br.com.mind5.business.personListRestricted.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.business.personListRestricted.model.action.StdPersoresMergePersolis;
import br.com.mind5.business.personListRestricted.model.checker.PersoresCheckDummy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPersoresSelect extends DeciTreeReadTemplate<PersoresInfo> {
	
	public RootPersoresSelect(DeciTreeOption<PersoresInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersoresInfo> buildDecisionCheckerHook(DeciTreeOption<PersoresInfo> option) {
		List<ModelChecker<PersoresInfo>> queue = new ArrayList<>();		
		ModelChecker<PersoresInfo> checker;

		checker = new PersoresCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersoresInfo>> buildActionsOnPassedHook(DeciTreeOption<PersoresInfo> option) {
		List<ActionStd<PersoresInfo>> actions = new ArrayList<>();
		
		ActionStd<PersoresInfo> mergePersolis = new StdPersoresMergePersolis(option);
		
		actions.add(mergePersolis);
		return actions;
	}
}
