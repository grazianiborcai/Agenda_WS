package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiNodeSnapshot;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiRootSelect;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiDaoUpdate;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceFilename;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceLChanged;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceUri;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiEnforceUriExternal;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiMergeFath;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiMergeToReplace;
import br.com.mind5.file.sysFileImage.model.action.FimgysVisiWriteOnDisk;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckExist;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckLangu;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckReference;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckReplace;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class FimgysRootReplace extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public FimgysRootReplace(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysInfo> buildCheckerHook(DeciTreeOption<FimgysInfo> option) {
		List<ModelChecker<FimgysInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgysCheckReplace(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimgysCheckReference(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgysCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimgysCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgysInfo> mergeToReplace = new ActionStdCommom<FimgysInfo>(option, FimgysVisiMergeToReplace.class);	
		ActionLazy<FimgysInfo> enforceLChanged = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceLChanged.class);
		ActionLazy<FimgysInfo> enforceFilename = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceFilename.class);
		ActionLazy<FimgysInfo> mergeFath = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiMergeFath.class);
		ActionLazy<FimgysInfo> enforceUri = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceUri.class);
		ActionLazy<FimgysInfo> enforceUriExternal = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiEnforceUriExternal.class);
		ActionLazy<FimgysInfo> update = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiDaoUpdate.class);
		ActionLazy<FimgysInfo> snapshot = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiNodeSnapshot.class);
		ActionLazy<FimgysInfo> writeOnDisk = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiWriteOnDisk.class);
		ActionLazy<FimgysInfo> select = new ActionLazyCommom<FimgysInfo>(option, FimgysVisiRootSelect.class);
		
		mergeToReplace.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceFilename);
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
