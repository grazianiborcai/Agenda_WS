package br.com.mind5.masterData.countryLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.action.LazyCountralRootSelect;
import br.com.mind5.masterData.countryLegal.model.action.StdCountralMergeCountrarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountralSearch extends DeciTreeTemplateRead<CountralInfo> {
	
	public RootCountralSearch(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountralInfo> buildCheckerHook(DeciTreeOption<CountralInfo> option) {
		List<ModelChecker<CountralInfo>> queue = new ArrayList<>();		
		ModelChecker<CountralInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountralInfo>> buildActionsOnPassedHook(DeciTreeOption<CountralInfo> option) {
		List<ActionStd<CountralInfo>> actions = new ArrayList<>();
		
		ActionStd<CountralInfo> countrarch = new StdCountralMergeCountrarch(option);
		ActionLazy<CountralInfo> select = new LazyCountralRootSelect(option.conn, option.schemaName);
		
		countrarch.addPostAction(select);
		
		actions.add(countrarch);
		return actions;
	}
}
