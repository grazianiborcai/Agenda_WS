package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.FimgVisiNodeSnapshot;
import br.com.mind5.file.fileImage.model.action.FimgVisiRootSelect;
import br.com.mind5.file.fileImage.model.action.FimgVisiDaoUpdate;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceFilename;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceUri;
import br.com.mind5.file.fileImage.model.action.FimgVisiEnforceUriExternal;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeFath;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeToReplace;
import br.com.mind5.file.fileImage.model.action.FimgVisiMergeUsername;
import br.com.mind5.file.fileImage.model.action.FimgVisiWriteOnDisk;
import br.com.mind5.file.fileImage.model.checker.FimgCheckExist;
import br.com.mind5.file.fileImage.model.checker.FimgCheckLangu;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReference;
import br.com.mind5.file.fileImage.model.checker.FimgCheckReplace;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgRootReplace extends DeciTreeTemplateWrite<FimgInfo> {
	
	public FimgRootReplace(DeciTreeOption<FimgInfo> option) {
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
		
		ActionStd<FimgInfo> mergeToReplace = new ActionStdCommom<FimgInfo>(option, FimgVisiMergeToReplace.class);	
		ActionLazy<FimgInfo> enforceLChanged = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceLChanged.class);	
		ActionLazy<FimgInfo> enforceLChangedBy = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeUsername.class);
		ActionLazy<FimgInfo> enforceFilename = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceFilename.class);
		ActionLazy<FimgInfo> mergeFath = new ActionLazyCommom<FimgInfo>(option, FimgVisiMergeFath.class);
		ActionLazy<FimgInfo> enforceUri = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceUri.class);
		ActionLazy<FimgInfo> enforceUriExternal = new ActionLazyCommom<FimgInfo>(option, FimgVisiEnforceUriExternal.class);
		ActionLazy<FimgInfo> update = new ActionLazyCommom<FimgInfo>(option, FimgVisiDaoUpdate.class);
		ActionLazy<FimgInfo> snapshot = new ActionLazyCommom<FimgInfo>(option, FimgVisiNodeSnapshot.class);
		ActionLazy<FimgInfo> writeOnDisk = new ActionLazyCommom<FimgInfo>(option, FimgVisiWriteOnDisk.class);
		ActionLazy<FimgInfo> select = new ActionLazyCommom<FimgInfo>(option, FimgVisiRootSelect.class);
		
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
