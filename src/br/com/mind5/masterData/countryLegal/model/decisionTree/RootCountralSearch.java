package br.com.mind5.masterData.countryLegal.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.action.LazyCountralRootSelect;
import br.com.mind5.masterData.countryLegal.model.action.StdCountralMergeCountrarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountralSearch extends DeciTreeTemplateReadV2<CountralInfo> {
	
	public RootCountralSearch(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountralInfo> buildCheckerHook(DeciTreeOption<CountralInfo> option) {
		List<ModelCheckerV1<CountralInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountralInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CountralInfo>> buildActionsOnPassedHook(DeciTreeOption<CountralInfo> option) {
		List<ActionStdV2<CountralInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CountralInfo> countrarch = new StdCountralMergeCountrarch(option);
		ActionLazy<CountralInfo> select = new LazyCountralRootSelect(option.conn, option.schemaName);
		
		countrarch.addPostAction(select);
		
		actions.add(countrarch);
		return actions;
	}
}
