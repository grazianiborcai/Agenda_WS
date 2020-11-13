package br.com.mind5.payment.payOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemNodeRefresh;
import br.com.mind5.payment.payOrderItem.model.action.LazyPayordemUpdate;
import br.com.mind5.payment.payOrderItem.model.action.StdPayordemEnforceLChanged;

public final class NodePayordemUpdate extends DeciTreeTemplateWriteV2<PayordemInfo> {
	
	public NodePayordemUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordemInfo> buildCheckerHook(DeciTreeOption<PayordemInfo> option) {
		List<ModelCheckerV1<PayordemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordemInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayordemInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordemInfo> option) {
		List<ActionStdV2<PayordemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PayordemInfo> enforceLChanged = new StdPayordemEnforceLChanged(option);
		ActionLazy<PayordemInfo> update = new LazyPayordemUpdate(option.conn, option.schemaName);
		ActionLazy<PayordemInfo> refresh = new LazyPayordemNodeRefresh(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(update);
		update.addPostAction(refresh);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
