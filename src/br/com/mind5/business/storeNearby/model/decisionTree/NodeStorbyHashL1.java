package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeToSelect;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyNodeHashL2;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyPruneEmpty;
import br.com.mind5.business.storeNearby.model.action.StdStorbyGeoshGenerate;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorbyHashL1 extends DeciTreeTemplateWriteV2<StorbyInfo> {
	
	public NodeStorbyHashL1(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> geoshGenerate = new StdStorbyGeoshGenerate(option);
		ActionLazyV1<StorbyInfo> nodeL2 = new LazyStorbyNodeHashL2(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> select = new LazyStorbyMergeToSelect(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> pruneEmpty = new LazyStorbyPruneEmpty(option.conn, option.schemaName);
		
		geoshGenerate.addPostAction(nodeL2);
		nodeL2.addPostAction(select);
		select.addPostAction(pruneEmpty);
		
		actions.add(geoshGenerate);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
