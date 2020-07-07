package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.LazyNotesDaoDelete;
import br.com.mind5.business.notes.model.action.LazyNotesRootUpdate;
import br.com.mind5.business.notes.model.action.StdNotesMergeToSelect;
import br.com.mind5.business.notes.model.checker.NotesCheckDelete;
import br.com.mind5.business.notes.model.checker.NotesCheckExist;
import br.com.mind5.business.notes.model.checker.NotesCheckLangu;
import br.com.mind5.business.notes.model.checker.NotesCheckOwner;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootNotesDelete extends DeciTreeTemplateWriteV2<NotesInfo> {
	
	public RootNotesDelete(DeciTreeOption<NotesInfo> option) {
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
		checker = new NotesCheckDelete(checkerOption);
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
		checker = new NotesCheckOwner(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new NotesCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueueV2<NotesInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStdV1<NotesInfo>> actions = new ArrayList<>();
		
		ActionStdV1<NotesInfo> select = new StdNotesMergeToSelect(option);
		ActionLazyV1<NotesInfo> update = new LazyNotesRootUpdate(option.conn, option.schemaName);
		ActionLazyV1<NotesInfo> delete = new LazyNotesDaoDelete(option.conn, option.schemaName);
		
		select.addPostAction(update);
		select.addPostAction(delete);		
		
		actions.add(select);
		return actions;
	}
}
