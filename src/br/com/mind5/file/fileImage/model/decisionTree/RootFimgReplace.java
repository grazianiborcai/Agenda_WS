package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoUpdate;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceFilename;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUri;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUriExternal;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeFath;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.LazyFimgNodeSnapshot;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootSelect;
import br.com.mind5.file.fileImage.model.action.LazyFimgWriteOnDisk;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeToReplace;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExist;
import br.com.mind5.file.fileImage.model.checker.FimgCheckLangu;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReference;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReplace;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFimgReplace extends DeciTreeTemplateWrite<FimgInfo> {
	
	public RootFimgReplace(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckReplace(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgCheckReference(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeToReplace = new StdFimgMergeToReplace(option);	
		ActionLazy<FimgInfo> enforceLChanged = new LazyFimgEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceFilename = new LazyFimgEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FimgInfo> mergeFath = new LazyFimgMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUri = new LazyFimgEnforceUri(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUriExternal = new LazyFimgEnforceUriExternal(option.conn, option.schemaName);
		ActionLazy<FimgInfo> update = new LazyFimgDaoUpdate(option.conn, option.schemaName);
		ActionLazy<FimgInfo> snapshot = new LazyFimgNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<FimgInfo> writeOnDisk = new LazyFimgWriteOnDisk(option.conn, option.schemaName);
		ActionLazy<FimgInfo> select = new LazyFimgRootSelect(option.conn, option.schemaName);
		
		mergeToReplace.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);
		enforceUri.addPostAction(enforceUriExternal);
		enforceUriExternal.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(writeOnDisk);
		writeOnDisk.addPostAction(select);
		
		actions.add(mergeToReplace);		
		return actions;
	}
}
