package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonInsert;
import br.com.gda.business.person.model.action.LazyPersonNodeSnapshot;
import br.com.gda.business.person.model.action.LazyPersonMergeUsername;
import br.com.gda.business.person.model.action.StdPersonEnforceLChanged;
import br.com.gda.business.person.model.checker.PersonCheckEntityCateg;
import br.com.gda.business.person.model.checker.PersonCheckGender;
import br.com.gda.business.person.model.checker.PersonCheckLangu;
import br.com.gda.business.person.model.checker.PersonCheckOwner;
import br.com.gda.business.person.model.checker.PersonCheckTechField;
import br.com.gda.business.person.model.checker.PersonCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPersonInsert extends DeciTreeWriteTemplate<PersonInfo> {
	
	public RootPersonInsert(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PersonCheckWrite();
		queue.add(checker);
		
		checker = new PersonCheckTechField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckGender(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckEntityCateg(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> nodeL1 = new NodePersonInsertL1(option).toAction();	
		ActionStd<PersonInfo> nodeL2 = new NodePersonInsertL2(option).toAction();	
		ActionStd<PersonInfo> enforceLChanged = new StdPersonEnforceLChanged(option);
		ActionLazy<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazy<PersonInfo> insert = new LazyPersonInsert(option.conn, option.schemaName);
		ActionLazy<PersonInfo> snapshot = new LazyPersonNodeSnapshot(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		
		actions.add(nodeL1);	
		actions.add(nodeL2);
		actions.add(enforceLChanged);
		return actions;
	}
}
