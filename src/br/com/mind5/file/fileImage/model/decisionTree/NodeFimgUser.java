package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgEnforceCodUser;
import br.com.mind5.file.fileImage.model.action.StdFimgMergeUsername;
import br.com.mind5.file.fileImage.model.checker.FimgCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeFimgUser extends DeciTreeWriteTemplate<FimgInfo> {
	
	public NodeFimgUser(DeciTreeOption<FimgInfo> option) {
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
		
		ActionStd<FimgInfo> enforceLChangedBy = new StdFimgMergeUsername(option);	
		ActionLazy<FimgInfo> enforceCodUser = new LazyFimgEnforceCodUser(option.conn, option.schemaName);
		
		enforceLChangedBy.addPostAction(enforceCodUser);
		
		actions.add(enforceLChangedBy);		
		return actions;
	}
}
