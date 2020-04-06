package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.LazyPerarchMergeToSelect;
import br.com.mind5.business.personSearch.model.action.StdPerarchEnforceNameSearch;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckLangu;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckOwner;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerarchSelect extends DeciTreeTemplateRead<PerarchInfo> {
	
	public RootPerarchSelect(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PerarchInfo> buildCheckerHook(DeciTreeOption<PerarchInfo> option) {
		List<ModelCheckerV1<PerarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PerarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PerarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PerarchCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStdV1<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PerarchInfo> enforceNameSearch = new StdPerarchEnforceNameSearch(option);
		ActionLazyV1<PerarchInfo> select = new LazyPerarchMergeToSelect(option.conn, option.schemaName);		
		
		enforceNameSearch.addPostAction(select);

		actions.add(enforceNameSearch);		
		return actions;
	}
}
