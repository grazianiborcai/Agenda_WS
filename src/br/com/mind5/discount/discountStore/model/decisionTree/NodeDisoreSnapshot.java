package br.com.mind5.discount.discountStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreDaoUpdate;
import br.com.mind5.discount.discountStore.model.action.StdDisoreDisorapInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeDisoreSnapshot extends DeciTreeTemplateWrite<DisoreInfo> {
	
	public NodeDisoreSnapshot(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisoreInfo> buildCheckerHook(DeciTreeOption<DisoreInfo> option) {
		List<ModelChecker<DisoreInfo>> queue = new ArrayList<>();		
		ModelChecker<DisoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisoreInfo>> buildActionsOnPassedHook(DeciTreeOption<DisoreInfo> option) {
		List<ActionStd<DisoreInfo>> actions = new ArrayList<>();
		
		ActionStd<DisoreInfo> snapshot = new StdDisoreDisorapInsert(option);
		ActionLazy<DisoreInfo> update = new LazyDisoreDaoUpdate(option.conn, option.schemaName);
		
		snapshot.addPostAction(update);
		
		actions.add(snapshot);
		return actions;
	}
}
