package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonEnforceCreatedBy;
import br.com.gda.business.person.model.action.LazyPersonEnforceCreatedOn;
import br.com.gda.business.person.model.action.LazyPersonInsert;
import br.com.gda.business.person.model.action.StdPersonEnforceLChanged;
import br.com.gda.business.person.model.action.LazyPersonMergeUsername;
import br.com.gda.business.person.model.checker.PersonCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

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
		ActionLazy<PersonInfo> insert = new LazyPersonInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
