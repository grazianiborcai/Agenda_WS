package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoUpdate;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeToUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeFimgUpdate extends DeciTreeTemplateWrite<FimgInfo> {
	
	public NodeFimgUpdate(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStd<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStd<FimgInfo> mergeToUpdate = new StdFimgMergeToUpdate(option);	
		ActionLazy<FimgInfo> enforceLChanged = new LazyFimgEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazy<FimgInfo> update = new LazyFimgDaoUpdate(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
