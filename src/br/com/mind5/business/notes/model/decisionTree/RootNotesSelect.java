package br.com.mind5.business.notes.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.notes.model.action.StdNotesMergeToSelect;
import br.com.mind5.business.notes.model.checker.NotesCheckLangu;
import br.com.mind5.business.notes.model.checker.NotesCheckOwner;
import br.com.mind5.business.notes.model.checker.NotesCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootNotesSelect extends DeciTreeTemplateWrite<NotesInfo> {
	
	public RootNotesSelect(DeciTreeOption<NotesInfo> option) {
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
		checker = new NotesCheckRead(checkerOption);
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<NotesInfo>> buildActionsOnPassedHook(DeciTreeOption<NotesInfo> option) {
		List<ActionStd<NotesInfo>> actions = new ArrayList<>();
		
		ActionStd<NotesInfo> select = new StdNotesMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
