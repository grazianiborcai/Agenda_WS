package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoInsert;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCreatedBy;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCreatedOn;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootSelect;
import br.com.mind5.file.fileImage.model.action.LazyFimgRootUpdate;
import br.com.mind5.file.fileImage.model.action.StdFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeFimarch;
import br.com.mind5.file.fileImage.model.checker.FimgCheckFimarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeFimgCopy extends DeciTreeTemplateWrite<FimgInfo> {
	
	public NodeFimgCopy(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new FimgCheckFimarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> enforceLChanged = new StdFimgEnforceLChanged(option);	
		ActionLazy<FimgInfo> enforceCreatedOn = new LazyFimgEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> enforceCreatedBy = new LazyFimgEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<FimgInfo> insert = new LazyFimgDaoInsert(option.conn, option.schemaName);	
		ActionLazy<FimgInfo> select = new LazyFimgRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnFailedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeFimarch = new StdFimgMergeFimarch(option);
		ActionLazy<FimgInfo> update = new LazyFimgRootUpdate(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(update);
		
		actions.add(mergeFimarch);		
		return actions;
	}
}
