package br.com.mind5.masterData.countrySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.masterData.countrySearch.model.action.CountarchVisiDaoSelect;
import br.com.mind5.masterData.countrySearch.model.checker.CountarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CountarchRootSelect extends DeciTreeTemplateRead<CountarchInfo> {
	
	public CountarchRootSelect(DeciTreeOption<CountarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountarchInfo> buildCheckerHook(DeciTreeOption<CountarchInfo> option) {
		List<ModelChecker<CountarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CountarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CountarchInfo> option) {
		List<ActionStd<CountarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CountarchInfo> select = new ActionStdCommom<CountarchInfo>(option, CountarchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
