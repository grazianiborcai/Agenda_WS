package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonEnforceBirthdate;
import br.com.mind5.business.person.model.action.LazyPersonEnforceCreatedBy;
import br.com.mind5.business.person.model.action.LazyPersonEnforceCreatedOn;
import br.com.mind5.business.person.model.action.LazyPersonInsert;
import br.com.mind5.business.person.model.action.LazyPersonMergeUsername;
import br.com.mind5.business.person.model.action.LazyPersonNodeName;
import br.com.mind5.business.person.model.action.StdPersonEnforceLChanged;
import br.com.mind5.business.person.model.checker.PersonCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodePersonInsert extends DeciTreeWriteTemplate<PersonInfo> {
	
	public NodePersonInsert(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
	
		checker = new PersonCheckDummy();
		queue.add(checker);
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStdV1<PersonInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonInfo> enforceLChanged = new StdPersonEnforceLChanged(option);
		ActionLazyV1<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<PersonInfo> enforceCreatedOn = new LazyPersonEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<PersonInfo> enforceCreatedBy = new LazyPersonEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<PersonInfo> nodeName = new LazyPersonNodeName(option.conn, option.schemaName);	
		ActionLazyV1<PersonInfo> enforceBirthdate = new LazyPersonEnforceBirthdate(option.conn, option.schemaName);	
		ActionLazyV1<PersonInfo> insert = new LazyPersonInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(nodeName);
		nodeName.addPostAction(enforceBirthdate);
		enforceBirthdate.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
