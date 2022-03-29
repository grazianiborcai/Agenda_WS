package br.com.mind5.business.personRestricted.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personRestricted.info.PersoresInfo;
import br.com.mind5.business.personRestricted.model.action.PersoresVisiMergePersolis;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PersoresRootSelect extends DeciTreeTemplateRead<PersoresInfo> {
	
	public PersoresRootSelect(DeciTreeOption<PersoresInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersoresInfo> buildCheckerHook(DeciTreeOption<PersoresInfo> option) {
		List<ModelChecker<PersoresInfo>> queue = new ArrayList<>();		
		ModelChecker<PersoresInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersoresInfo>> buildActionsOnPassedHook(DeciTreeOption<PersoresInfo> option) {
		List<ActionStd<PersoresInfo>> actions = new ArrayList<>();
		
		ActionStd<PersoresInfo> mergePersolis = new ActionStdCommom<PersoresInfo>(option, PersoresVisiMergePersolis.class);	
		
		actions.add(mergePersolis);		
		return actions;
	}
}
