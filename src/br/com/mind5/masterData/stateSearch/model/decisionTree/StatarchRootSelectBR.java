package br.com.mind5.masterData.stateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.action.StatarchVisiEnforceCountryBR;
import br.com.mind5.masterData.stateSearch.model.action.StatarchVisiRootSelect;
import br.com.mind5.masterData.stateSearch.model.checker.StatarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StatarchRootSelectBR extends DeciTreeTemplateRead<StatarchInfo> {
	
	public StatarchRootSelectBR(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StatarchInfo> buildCheckerHook(DeciTreeOption<StatarchInfo> option) {
		List<ModelChecker<StatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StatarchInfo> option) {
		List<ActionStd<StatarchInfo>> actions = new ArrayList<>();
		
		ActionStd <StatarchInfo> enforceCountryBR = new ActionStdCommom <StatarchInfo>(option, StatarchVisiEnforceCountryBR.class);
		ActionLazy<StatarchInfo> select           = new ActionLazyCommom<StatarchInfo>(option, StatarchVisiRootSelect.class);
		
		enforceCountryBR.addPostAction(select);
		
		actions.add(enforceCountryBR);
		return actions;
	}
}
