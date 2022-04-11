package br.com.mind5.business.personBio.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.PerbioVisiRootDelete;
import br.com.mind5.business.personBio.model.checker.PerbioCheckPerbiorchPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PerbioNodePersonDelete extends DeciTreeTemplateRead<PerbioInfo> {
	
	public PerbioNodePersonDelete(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerbioInfo> buildCheckerHook(DeciTreeOption<PerbioInfo> option) {
		List<ModelChecker<PerbioInfo>> queue = new ArrayList<>();		
		ModelChecker<PerbioInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PerbioCheckPerbiorchPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnPassedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbioInfo> searchPerson = new PerbioRootSearchPerson(option).toAction();
		ActionLazy<PerbioInfo> delete = new ActionLazyCommom<PerbioInfo>(option, PerbioVisiRootDelete.class);
		
		searchPerson.addPostAction(delete);
		
		actions.add(searchPerson);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<PerbioInfo>> buildActionsOnFailedHook(DeciTreeOption<PerbioInfo> option) {
		List<ActionStd<PerbioInfo>> actions = new ArrayList<>();
		
		ActionStd<PerbioInfo> success = new ActionStdSuccessCommom<PerbioInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
