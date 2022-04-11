package br.com.mind5.business.personBio.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.PerbioVisiRootSelect;
import br.com.mind5.business.personBio.model.action.PerbioVisiMergePerbiorchPerson;
import br.com.mind5.business.personBio.model.checker.PerbioCheckSearch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PerbioRootSearchPerson extends DeciTreeTemplateRead<PerbioInfo> {
	
	public PerbioRootSearchPerson(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbioInfo> buildCheckerHook(DeciTreeOption<PerbioInfo> option) {
		List<ModelChecker<PerbioInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbioInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerbioCheckSearch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbioInfo> mergePerbiorch = new ActionStdCommom<PerbioInfo>(option, PerbioVisiMergePerbiorchPerson.class);
		ActionLazy<PerbioInfo> select = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiRootSelect.class);
		
		mergePerbiorch.addPostAction(select);
		
		actions.add(mergePerbiorch);
		return actions;
	}
}
