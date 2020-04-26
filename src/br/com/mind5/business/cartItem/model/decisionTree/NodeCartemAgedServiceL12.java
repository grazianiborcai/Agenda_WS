package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemEnforceAged;
import br.com.mind5.business.cartItem.model.action.LazyCartemMergeSymsg;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceSymsgL12;
import br.com.mind5.business.cartItem.model.checker.CartemCheckCarterco;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartemAgedServiceL12 extends DeciTreeTemplateWriteV2<CartemInfo> {
	
	public NodeCartemAgedServiceL12(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelCheckerV1<CartemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new CartemCheckCarterco(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> nodeL13 = new NodeCartemAgedServiceL13(option).toAction();	
		
		actions.add(nodeL13);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnFailedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> enforceSymsg = new StdCartemEnforceSymsgL12(option);	
		ActionLazyV1<CartemInfo> mergeSymsg = new LazyCartemMergeSymsg(option.conn, option.schemaName);
		ActionLazyV1<CartemInfo> enforceAged = new LazyCartemEnforceAged(option.conn, option.schemaName);
		
		enforceSymsg.addPostAction(mergeSymsg);
		mergeSymsg.addPostAction(enforceAged);
		
		actions.add(enforceSymsg);		
		return actions;
	}
}
