package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoInsert;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCreatedBy;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCreatedOn;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceFilename;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUri;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceUriExternal;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeFath;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.StdFimgEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeFimgInsert extends DeciTreeTemplateWriteV2<FimgInfo> {
	
	public NodeFimgInsert(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelCheckerV1<FimgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimgInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> enforceLChanged = new StdFimgEnforceLChanged(option);	
		ActionLazy<FimgInfo> enforceCreatedOn = new LazyFimgEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceCreatedBy = new LazyFimgEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceFilename = new LazyFimgEnforceFilename(option.conn, option.schemaName);
		ActionLazy<FimgInfo> mergeFath = new LazyFimgMergeFath(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUri = new LazyFimgEnforceUri(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceUriExternal = new LazyFimgEnforceUriExternal(option.conn, option.schemaName);
		ActionLazy<FimgInfo> insert = new LazyFimgDaoInsert(option.conn, option.schemaName);	
		
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
