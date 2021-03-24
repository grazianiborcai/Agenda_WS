package br.com.mind5.file.sysFileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysDaoInsert;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceCreatedOn;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceFilename;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceUri;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysEnforceUriExternal;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysMergeFath;
import br.com.mind5.file.sysFileImage.model.action.LazyFimgysNodeSnapshot;
import br.com.mind5.file.sysFileImage.model.action.StdFimgysEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeFimgysInsert extends DeciTreeTemplateWrite<FimgysInfo> {
	
	public NodeFimgysInsert(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgysInfo> buildCheckerHook(DeciTreeOption<FimgysInfo> option) {
		List<ModelChecker<FimgysInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgysInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgysInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgysInfo> option) {
		List<ActionStd<FimgysInfo>> actions = new ArrayList<>();	
		
		ActionStd<FimgysInfo> enforceLChanged = new StdFimgysEnforceLChanged(option);	
		ActionLazy<FimgysInfo> enforceCreatedOn = new LazyFimgysEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> enforceFilename = new LazyFimgysEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> mergeFath = new LazyFimgysMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> enforceUri = new LazyFimgysEnforceUri(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> enforceUriExternal = new LazyFimgysEnforceUriExternal(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> insert = new LazyFimgysDaoInsert(option.conn, option.schemaName);
		ActionLazy<FimgysInfo> snapshot = new LazyFimgysNodeSnapshot(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);	
		enforceUri.addPostAction(enforceUriExternal);
		enforceUriExternal.addPostAction(insert);
		insert.addPostAction(snapshot);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
