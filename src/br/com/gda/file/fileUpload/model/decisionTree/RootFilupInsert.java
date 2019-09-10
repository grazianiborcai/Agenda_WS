package br.com.gda.file.fileUpload.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.model.action.LazyFilupEnforceCreatedBy;
import br.com.gda.file.fileUpload.model.action.LazyFilupEnforceCreatedOn;
import br.com.gda.file.fileUpload.model.action.LazyFilupEnforceFilename;
import br.com.gda.file.fileUpload.model.action.LazyFilupInsert;
import br.com.gda.file.fileUpload.model.action.LazyFilupMergeUsername;
import br.com.gda.file.fileUpload.model.action.StdFilupEnforceLChanged;
import br.com.gda.file.fileUpload.model.checker.FilupCheckLangu;
import br.com.gda.file.fileUpload.model.checker.FilupCheckOwner;
import br.com.gda.file.fileUpload.model.checker.FilupCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFilupInsert extends DeciTreeWriteTemplate<FilupInfo> {
	
	public RootFilupInsert(DeciTreeOption<FilupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FilupInfo> buildDecisionCheckerHook(DeciTreeOption<FilupInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FilupInfo>> queue = new ArrayList<>();		
		ModelChecker<FilupInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new FilupCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new FilupCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new FilupCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FilupInfo>> buildActionsOnPassedHook(DeciTreeOption<FilupInfo> option) {
		List<ActionStd<FilupInfo>> actions = new ArrayList<>();		
		
		ActionStd<FilupInfo> enforceLChanged = new StdFilupEnforceLChanged(option);	
		ActionLazy<FilupInfo> enforceCreatedOn = new LazyFilupEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<FilupInfo> enforceLChangedBy = new LazyFilupMergeUsername(option.conn, option.schemaName);
		ActionLazy<FilupInfo> enforceCreatedBy = new LazyFilupEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<FilupInfo> enforceFilename = new LazyFilupEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FilupInfo> insert = new LazyFilupInsert(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceFilename);
		enforceFilename.addPostAction(insert);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
