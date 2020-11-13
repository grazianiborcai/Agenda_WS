package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoDelete;
import br.com.mind5.business.storeText.model.action.LazyStorextDaoUpdate;
import br.com.mind5.business.storeText.model.action.LazyStorextMergeUsername;
import br.com.mind5.business.storeText.model.action.StdStorextEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeStorextDeleteL1 extends DeciTreeTemplateWrite<StorextInfo> {

	public NodeStorextDeleteL1(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelChecker<StorextInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextInfo> checker;
			
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<StorextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextInfo> enforceLChanged = new StdStorextEnforceLChanged(option);
		ActionLazy<StorextInfo> enforceLChangedBy = new LazyStorextMergeUsername(option.conn, option.schemaName);
		ActionLazy<StorextInfo> update = new LazyStorextDaoUpdate(option.conn, option.schemaName);
		ActionLazy<StorextInfo> delete = new LazyStorextDaoDelete(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
