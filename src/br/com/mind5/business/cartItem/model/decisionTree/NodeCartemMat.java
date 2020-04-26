package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemNodeMatService;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceWeekday;
import br.com.mind5.business.cartItem.model.checker.CartemCheckMatarchService;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeCartemMat extends DeciTreeTemplateWriteV2<CartemInfo> {
	
	public NodeCartemMat(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelCheckerV1<CartemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CartemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CartemCheckMatarchService(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStdV1<CartemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CartemInfo> enforceWeekday = new StdCartemEnforceWeekday(option);
		ActionLazyV1<CartemInfo> service = new LazyCartemNodeMatService(option.conn, option.schemaName);
		
		enforceWeekday.addPostAction(service);
		
		actions.add(enforceWeekday);
		return actions;
	}
}
