package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceFilename;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUri;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUriExternal;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeFath;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootSelect;
import br.com.mind5.file.fileImage.model.action.LazyFimgUpdate;
import br.com.mind5.file.fileImage.model.action.LazyFimgWriteOnDisk;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeToReplace;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExist;
import br.com.mind5.file.fileImage.model.checker.FimgCheckLangu;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReference;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReplace;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootFimgReplace extends DeciTreeWriteTemplate<FimgInfo> {
	
	public RootFimgReplace(DeciTreeOption<FimgInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> mergeToReplace = new StdFimgMergeToReplace(option);	
		ActionLazyV1<FimgInfo> enforceLChanged = new LazyFimgEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> enforceFilename = new LazyFimgEnforceFilename(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> mergeFath = new LazyFimgMergeFath(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> enforceUri = new LazyFimgEnforceUri(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> enforceUriExternal = new LazyFimgEnforceUriExternal(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> update = new LazyFimgUpdate(option.conn, option.schemaName);	
		ActionLazyV1<FimgInfo> writeOnDisk = new LazyFimgWriteOnDisk(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> select = new LazyFimgRootSelect(option.conn, option.schemaName);
		
		mergeToReplace.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);
		enforceUri.addPostAction(enforceUriExternal);
		enforceUriExternal.addPostAction(update);
		update.addPostAction(writeOnDisk);
		writeOnDisk.addPostAction(select);
		
		actions.add(mergeToReplace);		
		return actions;
	}
}
