package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonRootInsert;
import br.com.mind5.business.person.model.action.StdPersonEnforceCategStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootPersonInsertStore extends DeciTreeTemplateWriteV2<PersonInfo> {
	
	public RootPersonInsertStore(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelCheckerV1<PersonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersonInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
			
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV2<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PersonInfo> enforceCateg = new StdPersonEnforceCategStore(option);	
		ActionLazy<PersonInfo> insert = new LazyPersonRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(insert);
		
		actions.add(enforceCateg);
		return actions;
	}
}
