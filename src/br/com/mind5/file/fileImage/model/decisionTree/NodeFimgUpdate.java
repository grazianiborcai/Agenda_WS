package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceLChanged;
import br.com.mind5.file.fileImage.model.action.LazyFimgMergeUsername;
import br.com.mind5.file.fileImage.model.action.LazyFimgUpdate;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeToUpdate;
import br.com.mind5.file.fileImage.model.checker.FimgCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeFimgUpdate extends DeciTreeWriteTemplate<FimgInfo> {
	
	public NodeFimgUpdate(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimgInfo> buildDecisionCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelChecker<FimgInfo>> queue = new ArrayList<>();		
		ModelChecker<FimgInfo> checker;	

		checker = new FimgCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV1<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<FimgInfo> mergeToUpdate = new StdFimgMergeToUpdate(option);	
		ActionLazyV1<FimgInfo> enforceLChanged = new LazyFimgEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<FimgInfo> enforceLChangedBy = new LazyFimgMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<FimgInfo> update = new LazyFimgUpdate(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
