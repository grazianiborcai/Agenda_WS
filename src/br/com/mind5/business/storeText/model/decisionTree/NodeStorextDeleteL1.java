package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoDelete;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoUpdate;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeUsername;
import br.com.mind5.business.storeText.model.action.StdStorextEnforceLChanged;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStorextDeleteL1 extends DeciTreeTemplateWriteV2<StorextInfo> {

	public NodeStorextDeleteL1(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelCheckerV1<StorextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextInfo> checker;
			
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStdV1<StorextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextInfo> enforceLChanged = new StdStorextEnforceLChanged(option);
		ActionLazyV1<StorextInfo> enforceLChangedBy = new LazyStorextMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<StorextInfo> update = new LazyStorextDaoUpdate(option.conn, option.schemaName);
		ActionLazyV1<StorextInfo> delete = new LazyStorextDaoDelete(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
