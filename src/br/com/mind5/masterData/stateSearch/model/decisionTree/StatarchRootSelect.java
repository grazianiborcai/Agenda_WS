package br.com.mind5.masterData.stateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.action.StatarchVisiDaoSelect;
import br.com.mind5.masterData.stateSearch.model.action.StatarchVisiMergeCountry;
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

public final class StatarchRootSelect extends DeciTreeTemplateRead<StatarchInfo> {
	
	public StatarchRootSelect(DeciTreeOption<StatarchInfo> option) {
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
		
		ActionStd <StatarchInfo> select       = new ActionStdCommom <StatarchInfo>(option, StatarchVisiDaoSelect.class);
		ActionLazy<StatarchInfo> mergeCountry = new ActionLazyCommom<StatarchInfo>(option, StatarchVisiMergeCountry.class);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
