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
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootNotesInsert extends DeciTreeTemplateWriteV2<NotesInfo> {
	
	public RootNotesInsert(DeciTreeOption<NotesInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<NotesInfo> buildCheckerHook(DeciTreeOption<NotesInfo> option) {
		List<ModelCheckerV1<NotesInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<NotesInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStdV1<NotesInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<NotesInfo> enforceLChanged = new StdNotesEnforceLChanged(option);	
		ActionLazyV1<NotesInfo> enforceLChangedBy = new LazyNotesMergeUsername(option.conn, option.schemaName);		
		ActionLazyV1<NotesInfo> enforceCreatedBy = new LazyNotesEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazyV1<NotesInfo> enforceCreatedOn = new LazyNotesEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<NotesInfo> insert = new LazyNotesDaoInsert(option.conn, option.schemaName);
		ActionLazyV1<NotesInfo> select = new LazyNotesRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
