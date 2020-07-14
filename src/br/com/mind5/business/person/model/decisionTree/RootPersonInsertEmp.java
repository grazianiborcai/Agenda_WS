package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonNodeSytotauhL1;
import br.com.mind5.business.person.model.action.LazyPersonRootInsert;
import br.com.mind5.business.person.model.action.StdPersonEnforceCategEmp;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootPersonInsertEmp extends DeciTreeTemplateWriteV2<PersonInfo> {
	
	public RootPersonInsertEmp(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelCheckerV1<PersonInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersonInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
			
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV1<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonInfo> enforceCateg = new StdPersonEnforceCategEmp(option);
		ActionLazyV1<PersonInfo> nodeSytotauh = new LazyPersonNodeSytotauhL1(option.conn, option.schemaName);
		ActionLazyV1<PersonInfo> insert = new LazyPersonRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(insert);
		
		actions.add(enforceCateg);
		return actions;
	}
}
