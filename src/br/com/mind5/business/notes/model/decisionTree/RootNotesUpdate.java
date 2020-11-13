package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.LazyNotesDaoUpdate;
import br.com.mind5.business.notes.model.action.LazyNotesEnforceLChanged;
import br.com.mind5.business.notes.model.action.LazyNotesMergeUsername;
import br.com.mind5.business.notes.model.action.LazyNotesRootSelect;
import br.com.mind5.business.notes.model.action.StdNotesMergeToUpdate;
import br.com.mind5.business.notes.model.checker.NotesCheckExist;
import br.com.mind5.business.notes.model.checker.NotesCheckLangu;
import br.com.mind5.business.notes.model.checker.NotesCheckOwner;
import br.com.mind5.business.notes.model.checker.NotesCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootNotesUpdate extends DeciTreeTemplateWriteV2<NotesInfo> {
	
	public RootNotesUpdate(DeciTreeOption<NotesInfo> option) {
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new NotesCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStdV1<NotesInfo>> actions = new ArrayList<>();

		ActionStdV1<NotesInfo> mergeToUpdate = new StdNotesMergeToUpdate(option);
		ActionLazy<NotesInfo> enforceLChanged = new LazyNotesEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<NotesInfo> enforceLChangedBy = new LazyNotesMergeUsername(option.conn, option.schemaName);
		ActionLazy<NotesInfo> update = new LazyNotesDaoUpdate(option.conn, option.schemaName);
		ActionLazy<NotesInfo> select = new LazyNotesRootSelect(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
