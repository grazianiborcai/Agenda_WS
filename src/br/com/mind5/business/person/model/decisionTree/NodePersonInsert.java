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
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
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
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> enforceLChanged = new StdPersonEnforceLChanged(option);
		ActionLazy<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazy<PersonInfo> enforceCreatedOn = new LazyPersonEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> enforceCreatedBy = new LazyPersonEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<PersonInfo> nodeName = new LazyPersonNodeName(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> enforceBirthdate = new LazyPersonEnforceBirthdate(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> insert = new LazyPersonInsert(option.conn, option.schemaName);
		
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
