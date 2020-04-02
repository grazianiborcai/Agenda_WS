package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonEnforceNameSearch;
import br.com.mind5.business.person.model.action.StdPersonEnforceNameDisplay;
import br.com.mind5.business.person.model.action.StdPersonEnforceNameSearch;
import br.com.mind5.business.person.model.checker.PersonCheckHasNameDisplay;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePersonName extends DeciTreeWriteTemplate<PersonInfo> {
	
	public NodePersonName(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonCheckHasNameDisplay(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV1<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonInfo> enforceNameSearch = new StdPersonEnforceNameSearch(option);
		
		actions.add(enforceNameSearch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<PersonInfo>> buildActionsOnFailedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV1<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonInfo> enforceNameDisplay = new StdPersonEnforceNameDisplay(option);
		ActionLazyV1<PersonInfo> enforceNameSearch = new LazyPersonEnforceNameSearch(option.conn, option.schemaName);	
		
		enforceNameDisplay.addPostAction(enforceNameSearch);
		
		actions.add(enforceNameDisplay);	
		return actions;
	}
}
