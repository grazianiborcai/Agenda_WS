package br.com.mind5.file.fileImage.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.LazyFimgDaoUpdate;
import br.com.mind5.file.fileImage.model.action.StdFimgEnforceCoverOff;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeFimgCoverOffL4 extends DeciTreeTemplateWriteV2<FimgInfo> {
	
	public NodeFimgCoverOffL4(DeciTreeOption<FimgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimgInfo> buildCheckerHook(DeciTreeOption<FimgInfo> option) {
		List<ModelCheckerV1<FimgInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimgInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FimgInfo>> buildActionsOnPassedHook(DeciTreeOption<FimgInfo> option) {
		List<ActionStdV2<FimgInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<FimgInfo> enforceCoverOff = new StdFimgEnforceCoverOff(option);	
		ActionLazy<FimgInfo> update = new LazyFimgDaoUpdate(option.conn, option.schemaName);
		
		enforceCoverOff.addPostAction(update);
		
		actions.add(enforceCoverOff);		
		return actions;
	}
}
