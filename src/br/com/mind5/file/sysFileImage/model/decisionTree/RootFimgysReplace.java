package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysDaoUpdate;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceFilename;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceLChanged;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceUri;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceUriExternal;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysMergeFath;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysNodeSnapshot;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysRootSelect;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysWriteOnDisk;
import br.com.mind5.file.sysFileImage.model.action.StdFimgysMergeToReplace;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckExist;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckLangu;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckReference;
import br.com.mind5.file.sysFileImage.model.checker.FimgysCheckReplace;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootFimgysReplace extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public RootFimgysReplace(DeciTreeOption<FimgysInfo> option) {
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
		
		ActionStd<FimgysInfo> mergeToReplace = new StdFimgysMergeToReplace(option);	
		ActionLazy<FimgysInfo> enforceLChanged = new LazyFimgysEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> enforceFilename = new LazyFimgysEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> mergeFath = new LazyFimgysMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> enforceUri = new LazyFimgysEnforceUri(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> enforceUriExternal = new LazyFimgysEnforceUriExternal(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> update = new LazyFimgysDaoUpdate(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> snapshot = new LazyFimgysNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> writeOnDisk = new LazyFimgysWriteOnDisk(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> select = new LazyFimgysRootSelect(option.conn, option.schemaName);
		
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
