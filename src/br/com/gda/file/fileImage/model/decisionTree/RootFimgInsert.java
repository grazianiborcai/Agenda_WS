package br.com.gda.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceCreatedBy;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceCreatedOn;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceFilename;
import br.com.gda.file.fileImage.model.action.LazyFimgEnforceUri;
import br.com.gda.file.fileImage.model.action.LazyFimgInsert;
import br.com.gda.file.fileImage.model.action.LazyFimgMergeFath;
import br.com.gda.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.gda.file.fileImage.model.action.LazyFimgRootSelect;
import br.com.gda.file.fileImage.model.action.LazyFimgWriteOnDisk;
import br.com.gda.file.fileImage.model.action.StdFimgEnforceLChanged;
import br.com.gda.file.fileImage.model.checker.FimgCheckLangu;
import br.com.gda.file.fileImage.model.checker.FimgCheckOwner;
import br.com.gda.file.fileImage.model.checker.FimgCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFimgInsert extends DeciTreeWriteTemplate<FimgInfo> {
	
	public RootFimgInsert(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> nodeStore = new NodeFimgStore(option).toAction();
		ActionStd<FimgInfo> enforceLChanged = new StdFimgEnforceLChanged(option);	
		ActionLazy<FimgInfo> enforceCreatedOn = new LazyFimgEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceCreatedBy = new LazyFimgEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceFilename = new LazyFimgEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FimgInfo> mergeFath = new LazyFimgMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUri = new LazyFimgEnforceUri(option.conn, option.schemaName);
		ActionLazy<FimgInfo> insert = new LazyFimgInsert(option.conn, option.schemaName);	
		ActionLazy<FimgInfo> writeOnDisk = new LazyFimgWriteOnDisk(option.conn, option.schemaName);
		ActionLazy<FimgInfo> select = new LazyFimgRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);		
		enforceUri.addPostAction(insert);
		insert.addPostAction(writeOnDisk);
		writeOnDisk.addPostAction(select);
		
		actions.add(nodeStore);
		actions.add(enforceLChanged);		
		return actions;
	}
}
