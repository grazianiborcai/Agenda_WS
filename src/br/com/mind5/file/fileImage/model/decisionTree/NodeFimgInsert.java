package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCreatedBy;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCreatedOn;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceFilename;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUri;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUriExternal;
import br.com.mind5.file.fileImage.model.action.LazyFimgInsert;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeFath;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.StdFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.checker.FimgCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeFimgInsert extends DeciTreeWriteTemplate<FimgInfo> {
	
	public NodeFimgInsert(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	

		checker = new FimgCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> enforceLChanged = new StdFimgEnforceLChanged(option);	
		ActionLazy<FimgInfo> enforceCreatedOn = new LazyFimgEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceCreatedBy = new LazyFimgEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceFilename = new LazyFimgEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FimgInfo> mergeFath = new LazyFimgMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUri = new LazyFimgEnforceUri(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUriExternal = new LazyFimgEnforceUriExternal(option.conn, option.schemaName);
		ActionLazy<FimgInfo> insert = new LazyFimgInsert(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceFilename);
		enforceFilename.addPostAction(mergeFath);
		mergeFath.addPostAction(enforceUri);	
		enforceUri.addPostAction(enforceUriExternal);
		enforceUriExternal.addPostAction(insert);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
