package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.LazyNotesDaoInsert;
import br.com.mind5.business.notes.model.action.LazyNotesEnforceCreatedBy;
import br.com.mind5.business.notes.model.action.LazyNotesEnforceCreatedOn;
import br.com.mind5.business.notes.model.action.LazyNotesMergeUsername;
import br.com.mind5.business.notes.model.action.LazyNotesRootSelect;
import br.com.mind5.business.notes.model.action.StdNotesEnforceLChanged;
import br.com.mind5.business.notes.model.checker.NotesCheckLangu;
import br.com.mind5.business.notes.model.checker.NotesCheckOwner;
import br.com.mind5.business.notes.model.checker.NotesCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootNotesInsert extends DeciTreeTemplateWrite<NotesInfo> {
	
	public RootNotesInsert(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<NotesInfo> buildCheckerHook(DeciTreeOption<NotesInfo> option) {
		List<ModelChecker<NotesInfo>> queue = new ArrayList<>();		
		ModelChecker<NotesInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new NotesCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new NotesCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new NotesCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStd<NotesInfo>> actions = new ArrayList<>();		
		
		ActionStd<NotesInfo> nodeCustomer = new NodeNotesCustomerL1(option).toAction();
		ActionStd<NotesInfo> enforceLChanged = new StdNotesEnforceLChanged(option);	
		ActionLazy<NotesInfo> enforceLChangedBy = new LazyNotesMergeUsername(option.conn, option.schemaName);		
		ActionLazy<NotesInfo> enforceCreatedBy = new LazyNotesEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<NotesInfo> enforceCreatedOn = new LazyNotesEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<NotesInfo> insert = new LazyNotesDaoInsert(option.conn, option.schemaName);
		ActionLazy<NotesInfo> select = new LazyNotesRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeCustomer);
		actions.add(enforceLChanged);
		return actions;
	}
}
