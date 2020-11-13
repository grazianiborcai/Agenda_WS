package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonEnforceNameSearch;
import br.com.mind5.business.person.model.action.StdPersonEnforceNameDisplay;
import br.com.mind5.business.person.model.action.StdPersonEnforceNameSearch;
import br.com.mind5.business.person.model.checker.PersonCheckHasNameDisplay;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodePersonName extends DeciTreeTemplateWriteV2<PersonInfo> {
	
	public NodePersonName(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelCheckerV1<PersonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersonInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckHasNameDisplay(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV2<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PersonInfo> enforceNameSearch = new StdPersonEnforceNameSearch(option);
		
		actions.add(enforceNameSearch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<PersonInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV2<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PersonInfo> enforceNameDisplay = new StdPersonEnforceNameDisplay(option);
		ActionLazy<PersonInfo> enforceNameSearch = new LazyPersonEnforceNameSearch(option.conn, option.schemaName);	
		
		enforceNameDisplay.addPostAction(enforceNameSearch);
		
		actions.add(enforceNameDisplay);	
		return actions;
	}
}
